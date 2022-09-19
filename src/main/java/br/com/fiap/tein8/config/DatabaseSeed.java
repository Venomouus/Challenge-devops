package br.com.fiap.tein8.config;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.tein8.model.Empresa;
import br.com.fiap.tein8.repository.EmpresaRepository;
import br.com.fiap.tein8.model.Aplicacao;
import br.com.fiap.tein8.repository.AplicacaoRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {


    @Autowired
    AplicacaoRepository aplicacaoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        

        
        aplicacaoRepository.saveAll(List.of(
            new Aplicacao(1L, "Portal", 3, 5, 6),

            new Aplicacao(2L, "Mobile", 2, 3, 4)
        ));

        empresaRepository.saveAll(List.of(
            new Empresa("Amazom","12.416.910/0001-03","Plataforma de vendas", "amazomlogin@gmail.com",passwordEncoder.encode("123"),
            new GregorianCalendar(2010, Calendar.FEBRUARY, 15),1600.00,"Aguardando pagamento"),

            new Empresa("Alura","11.139.533/0001-05","Plataforma de cursos de tecnologia online", "alura@gmail.com",passwordEncoder.encode("123"),
            new GregorianCalendar(2010, Calendar.FEBRUARY, 20),2200.,"Aguardando pagamento")
        ));

        
    }
    
}