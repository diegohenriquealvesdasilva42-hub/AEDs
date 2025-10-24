import java.util.Scanner;

//(ATV 3)
public class LabArvoreBinaria {

    public static int stringParaInt(String s) {
        int num = 0;
        int i = 0;
        boolean negativo = false;

        if (s.charAt(0) == '-') {
            negativo = true;
            i = 1;
        }

        while (i < s.length()) {
            char c = s.charAt(i);
            num = num * 10 + (c - '0');
            i++;
        }

        if (negativo) {
            num = -num;
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            if (linha.length() == 0)
                continue;

            String[] partes = linha.split(" ");
            String solicitacao = partes[0];

            if (solicitacao.equals("I")) {
                int valor = stringParaInt(partes[1]);
                arvore.inserir(valor);
            }

            else if (solicitacao.equals("P")) {
                int valor = stringParaInt(partes[1]);
                arvore.pesquisar(valor);
            }

            else if (solicitacao.equals("PRE")) {
                if (arvore.vazia()) {
                    System.out.println("V");
                } else {

                    arvore.caminharPre();
                }
            }

            else if (solicitacao.equals("POS")) {
                if (arvore.vazia()) {
                    System.out.println("V");
                } else {
                    arvore.caminharPos();
                }
            }

            else if (solicitacao.equals("EM")) {
                if (arvore.vazia()) {
                    System.out.println("V");
                } else {
                    arvore.caminharEm();
                }
            }
        }

        sc.close();
    }
}

// (ATV 1)
class No {
    int valor;
    No esq, dir;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}

// (ATV 2)
class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean vazia() {
        return raiz == null;
    }

    public void inserir(int x) {

        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.valor) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.valor) {
            i.dir = inserir(x, i.dir);
        }
        return i;
    }

    public boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, No i) {
        if (i == null) {
            System.out.println("N");
            return false;
        }

        System.out.print(i.valor + " ");

        if (x == i.valor) {
            System.out.println("S");
            return true;
        } else if (x < i.valor) {
            return pesquisar(x, i.esq);
        } else {
            return pesquisar(x, i.dir);
        }
    }

    public void caminharPre() {
        caminharPre(raiz);
        System.out.println();
    }

    private void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.valor + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void caminharPos() {
        caminharPos(raiz);
        System.out.println();
    }

    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.valor + " ");
        }
    }

    public void caminharEm() {
        caminharEm(raiz);
        System.out.println();
    }

    private void caminharEm(No i) {
        if (i != null) {
            caminharEm(i.esq);
            System.out.print(i.valor + " ");
            caminharEm(i.dir);
        }
    }

}
//Ass. Diego Henrique A. da Silva

