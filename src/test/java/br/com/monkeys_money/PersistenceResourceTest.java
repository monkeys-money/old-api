package br.com.monkeys_money;

import br.com.monkeys_money.infradb.model.Expenditure;
import br.com.monkeys_money.infradb.model.Investment;
import br.com.monkeys_money.infradb.model.Revenue;
import br.com.monkeys_money.infradb.model.User;
import br.com.monkeys_money.infradb.repository.ExpenditureRepository;
import br.com.monkeys_money.infradb.repository.InvestmentRepository;
import br.com.monkeys_money.infradb.repository.RevenueRepository;
import br.com.monkeys_money.infradb.repository.UserRespository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;

@QuarkusTest
public class PersistenceResourceTest {

    @Inject
    UserRespository userRespository;

    @Inject
    ExpenditureRepository expenditureRepository;

    @Inject
    RevenueRepository revenueRepository;

    @Inject
    InvestmentRepository investmentRepository;

    private Long idUser;

    @Test
    public void saveUserTest() {
        var user  = new User();
        user.setUsername("lhsribas");
        user.setEmail("lhs.ribas@gmail.com");
        user.setPassword("root@123");
        user.setDateCreation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        var u = userRespository.save(user);

        if(u.getId() != null && u.getId() > 0){
            idUser = u.getId();
        }else{
            Assertions.fail();
        }

        Assertions.assertNotNull(u);
    }

    @Test
    public void searchUserTest() {
        var u = userRespository.findByEmail("lhs.ribas@gmail.com");

        // assert not null
        Assertions.assertNotNull(u);

        // assert equals email
        Assertions.assertEquals("lhs.ribas@gmail.com", u.getEmail());
    }

    @Test
    public void saveExpenditureTest(){
        var user = new User();
        user.setId(idUser);

        var expenditure = new Expenditure();
        expenditure.setExpenditure("Tenis Nike SB 45");
        expenditure.setDescription("Tenis Nike, Presente para meu irmão");
        expenditure.setValue(750.50);
        expenditure.setUser(user);
        expenditure.setDateExpenditure(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        expenditure.setDateCreation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        var e = expenditureRepository.save(expenditure);

        Assertions.assertNotNull(e);
    }

    @Test
    public void searchExpenditureTest(){
        var e = expenditureRepository.findMany();

        if (e.size() <= 0)
            Assertions.fail();

        Assertions.assertNotNull(e);
    }

    @Test
    public void saveRevenueTest(){
        var user = new User();
        user.setId(idUser);

        var revenue = new Revenue();
        revenue.setRevenue("Freelancer");
        revenue.setDescription("Criação de logotipo para Arquitetura e Arts");
        revenue.setValue(5000.0);
        revenue.setUser(user);
        revenue.setDateRevenue(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        revenue.setDateCreation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        var e = revenueRepository.save(revenue);

        Assertions.assertNotNull(e);
    }

    @Test
    public void searchRevenueTest(){
        var r = revenueRepository.findMany();

        if(r.size() <= 0)
            Assertions.fail();

        Assertions.assertNotNull(r);
    }

    @Test
    public void saveInvestmentTest(){
        var user = new User();
        user.setId(idUser);

        var investment = new Investment();
        investment.setInvestment("Freelancer");
        investment.setDescription("Criação de logotipo para Arquitetura e Arts");
        investment.setValue(5000.0);
        investment.setUser(user);
        investment.setDateInvestment(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        investment.setDateCreation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        var e = investmentRepository.save(investment);

        Assertions.assertNotNull(e);
    }

    @Test
    public void searchInvestmentTest(){
        var i = investmentRepository.findMany();

        if(i.size() <= 0)
            Assertions.fail();

        Assertions.assertNotNull(i);
    }
}