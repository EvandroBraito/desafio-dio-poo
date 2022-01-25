package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Bootcamp;
import entities.Curso;
import entities.Dev;
import entities.Mentoria;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Curso> listCursos = new ArrayList<>();
		List<Mentoria> listMentorias = new ArrayList<>();
		List<Dev> listDev = new ArrayList<>();

		Bootcamp bootcamp = new Bootcamp();

		System.out.print("Quantos cursos voce quer cadastrar: ");
		int nCursos = sc.nextInt();

		for (int i = 1; i <= nCursos; i++) {
			System.out.println();
			System.out.println("Curso #" + i + ": ");

			System.out.print("Nome: ");
			sc.nextLine();
			String nameCurso = sc.nextLine();
			System.out.print("Descrição: ");
			String descricaoCurso = sc.nextLine();
			System.out.print("Carga horaria: ");
			int carga = sc.nextInt();

			Curso curso = new Curso();
			curso.setTitulo(nameCurso);
			curso.setDescricao(descricaoCurso);
			curso.setCargaHoraria(carga);
			listCursos.add(curso);
		}

		System.out.println();
		System.out.print("Quantas mentorias voce quer cadastrar: ");
		int nMentorias = sc.nextInt();

		for (int i = 1; i <= nMentorias; i++) {
			sc.nextLine();

			System.out.println();
			System.out.println("Mentorias #" + i + ": ");

			System.out.print("Titulo: ");
			String titulo = sc.nextLine();

			System.out.print("Descrição: ");
			String descricao = sc.next();

			Mentoria mentoria = new Mentoria();
			mentoria.setTitulo(titulo);
			mentoria.setDescricao(descricao);
			mentoria.setData(LocalDate.now());
			listMentorias.add(mentoria);
		}

		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");

		for (Curso obj : listCursos) {
			bootcamp.getConteudos().add(obj);
		}

		for (Mentoria obj : listMentorias) {
			bootcamp.getConteudos().add(obj);
		}

		System.out.println();
		System.out.print("Quantos Devs voce quer cadastrar neste Bootcamp: ");
		int nDevs = sc.nextInt();

		for (int i = 1; i <= nDevs; i++) {
			System.out.println();
			System.out.println("Dev #" + i + ": ");
			System.out.print("Nome: ");
			sc.nextLine();
			String nameDev = sc.next();

			Dev devs = new Dev();
			devs.setNome(nameDev);
			devs.inscreverBootcamp(bootcamp);
			listDev.add(devs);
		}

		System.out.println();

		while (true) {
			for (int i = 0, cont = 1; i < listDev.size(); i++, cont++) {
				System.out.println("Lista de devs: ");
				System.out.println("[ " + cont + " ] Nome: " + listDev.get(i).getNome() + "\nXP: "
						+ listDev.get(i).calcularTotalXp());
				System.out.println();
			}

			System.out.printf("Por favor, informe qual Dev progrediu no bootcamp, informando sua posicao: ");
			int pos = sc.nextInt();
			pos += -1;
			if (pos > listDev.size() || pos < 0) {
				System.out.println("O valor informado nao existe! Por favor, tente d novo");
			} else {
				listDev.get(pos).progredir();
				System.out.println("\nConteúdos Inscritos de " + listDev.get(pos).getNome() + " :"
						+ listDev.get(pos).getConteudosInscritos());
				System.out.println("\nConteúdos Concluídos de " + listDev.get(pos).getNome() + " :"
						+ listDev.get(pos).getConteudosConcluidos());
				System.out.println("XP:" + listDev.get(pos).calcularTotalXp());
			}
			System.out.printf("Deseja continuar? [s/n]: ");
			char contibuar = sc.next().charAt(0);
			if (contibuar == 's') {
				System.out.println("---------------------------");
			} else
				break;
		}

		System.out.println("Programa encerrado...");
		sc.close();
	}
}