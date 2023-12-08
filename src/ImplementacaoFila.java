import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFila extends Thread{

    private static ConcurrentLinkedQueue<ObjetoFila> pila_fila =
                            new ConcurrentLinkedQueue<ObjetoFila>();

    public static void add(ObjetoFila objetoFila) {
        pila_fila.add(objetoFila);
    }

    @Override
    public void run() {
        System.out.println("Fila rodando");



        while (true) {
            Iterator interacao = pila_fila.iterator();

            synchronized (interacao) { /* Bloquear o acesso a lista por outro processo */

                while (interacao.hasNext()) {  /* Enquanto conter dados na lista irá processar */

                    ObjetoFila processar = (ObjetoFila) interacao.next(); /* Captura do objeto atual */

                    System.out.println("-----------------------------------------");
                    System.out.println(processar.getEmail());
                    System.out.println(processar.getNome());

                    interacao.remove();

                    try { /* Descarga de memoria */
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                        /*e.printStackTrace(); */
                    }
                }

            }

            try { /* Descarga de memoria */
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                /*e.printStackTrace(); */
            }

        }


    }
}
