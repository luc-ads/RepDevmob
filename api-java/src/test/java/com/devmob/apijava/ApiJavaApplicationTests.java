package com.devmob.apijava;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

class ApiJavaApplicationTests {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Memoria memoria = new Memoria();
        Processador processador = new Processador();
        Temperatura temperatura = new Temperatura();
        DiscosGroup grupoDeDiscos = new DiscosGroup();
        ServicosGroup grupoDeServicos = new ServicosGroup();
        ProcessosGroup grupoDeProcessos = new ProcessosGroup();

        System.out.println(processador.getId());
        System.out.println(sistema.getSistemaOperacional());
        System.out.println(sistema.getFabricante());
        System.out.println(sistema.getArquitetura());
        System.out.println(Conversor.formatarBytes(memoria.getTotal()));
        System.out.println(Conversor.formatarBytes(grupoDeDiscos.getTamanhoTotal()));
        System.out.println(processador.getNome());
        System.out.println(processador.getNumeroCpusFisicas());
        System.out.println(processador.getNumeroCpusLogicas());

//        int n = 0;
//        
//        
//        
//        while (n < 10) {
//            System.out.println(processador.getUso());
//        }
//        System.out.println(memoria.toString());
//        pause(3000);
//        System.out.println(memoria.toString());
//        List<Disco> discos = grupoDeDiscos.getDiscos();
//        for (Disco disco : discos) {
//            System.out.println(disco);
//        }
//        pause(3000);
//        List<Disco> discos2 = grupoDeDiscos.getDiscos();
//        for (Disco disco2 : discos2) {
//            System.out.println(disco2);
//        }
//        pause(3000);
//        List<Disco> discos3 = grupoDeDiscos.getDiscos();
//        for (Disco disco3 : discos3) {
//            System.out.println(disco3);
//        }
//         System.out.println(sistema.getInicializado());
//        System.out.println(sistema.getTempoDeAtividade());
//        System.out.println(memoria.getTotal());
//        System.out.println(memoria.getEmUso());
//        System.out.println(processador.toString());
//        System.out.println(temperatura.toString());
//        System.out.println(grupoDeDiscos.getDiscos());
//        pause(3000);
//        System.out.println(grupoDeDiscos.getDiscos());
//        System.out.println(temperatura.toString());
//        System.out.println(processador.toString());
//        System.out.println(memoria.getEmUso());
//        System.out.println(memoria.getTotal());
//        System.out.println(sistema.getTempoDeAtividade());
//        System.out.println(sistema.getInicializado());
    }

}
