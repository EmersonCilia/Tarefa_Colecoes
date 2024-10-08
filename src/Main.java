import java.util.*;

public class Main {
    public static void main(String[] args) {

        //part 1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes separados por ','");
        String inputNomes = scanner.nextLine();

        String[] arrayDeNomes = inputNomes.split(",");
        List<String> nomes = new ArrayList<>(Arrays.asList(arrayDeNomes));

        nomes.replaceAll(String::trim);
        Collections.sort(nomes);

        System.out.println("Nomes ordenados:");
        for (String nome : nomes) {
            System.out.println(nome);
        }


        //parte 2
        HashMap<String, ArrayList<String>> nomesMap = new HashMap<>();

        nomesMap.put("m", new ArrayList<>());
        nomesMap.put("f", new ArrayList<>());

        System.out.println("Insira os nomes no formato 'nome-genero' (exemplo: 'Maria-f', 'Joao-m'). Digite sair para terminar:");

        while (true) {
            String inputNomesEGeneros = scanner.nextLine();

            if (inputNomesEGeneros.equalsIgnoreCase("sair")) {
                break;
            }

            String[] partes = inputNomesEGeneros.split("-");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String genero = partes[1].trim().toLowerCase();


                if (genero.equals("m") || genero.equals("f")) {
                    nomesMap.get(genero).add(nome);
                } else {
                    System.out.println("Genero inválido. Por favor coloque M para masculino e F para feminino");
                }
            } else {
                System.out.println("Formato inválido. Utilize o formato 'nome-genero'.");
            }
        }

        System.out.println("\nNomes categorizados por genero:");
        for (String genero : nomesMap.keySet()) {
            System.out.println(genero.equals("m") ? "\nNomes Masculinos:" : "\nNomes femininos:");
            for (String nome : nomesMap.get(genero)) {
                System.out.println(nome);
            }
        }
        scanner.close();
    }
}