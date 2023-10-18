package br.senai.sc.supertrunfofrutas.util;

import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.repository.CardRepository;
import br.senai.sc.supertrunfofrutas.business.repository.PersonRepository;
import br.senai.sc.supertrunfofrutas.security.model.User;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DBUtil {

    private PersonRepository personRepository;
    private CardRepository cardRepository;

    @PostConstruct
    public void fillDB(){
        personRepository.deleteAll();
        cardRepository.deleteAll();

        /*ADMIN*/
        Person personAdmin = new Person();
        personAdmin.setName("admin");
        personAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));

        personRepository.save(personAdmin);

        /*CARDS*/
    // Maracujá
        Card maracuja = new Card();
        maracuja.setName("Maracujá");
        maracuja.setRanking(2.0);
        maracuja.setQtyProteins(2.2);
        maracuja.setQtyGlucose(15.0);
        maracuja.setQtyCalories(97.0);
        maracuja.setUrl("https://vitat.com.br/wp-content/uploads/2019/12/depositphotos_69751357_xl-2015-1.jpg");
        cardRepository.save(maracuja);

    // Pera
        Card pera = new Card();
        pera.setName("Pera");
        pera.setRanking(5.0);
        pera.setQtyProteins(0.4);
        pera.setQtyGlucose(42.0);
        pera.setQtyCalories(58.0);
        pera.setUrl("https://conteudo.imguol.com.br/c/entretenimento/4e/2020/03/23/pera-1584989626321_v2_4x3.jpg");
        cardRepository.save(pera);

    // Carambola
        Card carambola = new Card();
        carambola.setName("Carambola");
        carambola.setRanking(3.0);
        carambola.setQtyProteins(1.4);
        carambola.setQtyGlucose(33.0);
        carambola.setQtyCalories(31.0);
        carambola.setUrl("https://images.ecycle.com.br/wp-content/uploads/2018/04/01162703/fresh-1557491_1920-1024x687.jpg.webp");
        cardRepository.save(carambola);

    // Amora
        Card amora = new Card();
        amora.setName("Amora");
        amora.setRanking(10.0);
        amora.setQtyProteins(1.2);
        amora.setQtyGlucose(5.0);
        amora.setQtyCalories(43.0);
        amora.setUrl("https://p2.trrsf.com/image/fget/cf/1200/675/middle/images.terra.com/2022/10/17/1173549954-beneficio-da-amora.jpg");
        cardRepository.save(amora);

    // Melancia
        Card melancia = new Card();
        melancia.setName("Melancia");
        melancia.setRanking(10.0);
        melancia.setQtyProteins(0.6);
        melancia.setQtyGlucose(72.0);
        melancia.setQtyCalories(30.0);
        melancia.setUrl("https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2023/05/melancia_01.jpg?w=876&h=484&crop=1");
        cardRepository.save(melancia);

    // Morango
        Card morango = new Card();
        morango.setName("Morango");
        morango.setRanking(10.0);
        morango.setQtyProteins(0.7);
        morango.setQtyGlucose(40.0);
        morango.setQtyCalories(32.0);
        morango.setUrl("https://conteudo.imguol.com.br/c/entretenimento/78/2018/02/28/morango-1519823853148_v2_4x3.jpg");
        cardRepository.save(morango);

    // Abacate
        Card abacate = new Card();
        abacate.setName("Abacate");
        abacate.setRanking(1.0);
        abacate.setQtyProteins(2.0);
        abacate.setQtyGlucose(0.2);
        abacate.setQtyCalories(160.0);
        abacate.setUrl("https://minhasaude.proteste.org.br/wp-content/uploads/2022/10/abacates.jpg");
        cardRepository.save(abacate);

    // Abacaxi
        Card abacaxi = new Card();
        abacaxi.setName("Abacaxi");
        abacaxi.setRanking(7.0);
        abacaxi.setQtyProteins(0.9);
        abacaxi.setQtyGlucose(59.0);
        abacaxi.setQtyCalories(50.0);
        abacaxi.setUrl("https://conteudo.imguol.com.br/c/entretenimento/04/2017/12/11/abacaxi-1513012505452_v2_3x4.jpg");
        cardRepository.save(abacaxi);

    // Açai
        Card acai = new Card();
        acai.setName("Açai");
        acai.setRanking(4.0);
        acai.setQtyProteins(8.1);
        acai.setQtyGlucose(11.0);
        acai.setQtyCalories(247.0);
        acai.setUrl("https://www.infoescola.com/wp-content/uploads/2020/01/acao-sementes-633723893.jpg");
        cardRepository.save(acai);

    // Blueberry
        Card blueberry = new Card();
        blueberry.setName("Blueberry");
        blueberry.setRanking(8.0);
        blueberry.setQtyProteins(0.7);
        blueberry.setQtyGlucose(53.0);
        blueberry.setQtyCalories(57.0);
        blueberry.setUrl("https://conteudo.imguol.com.br/c/entretenimento/73/2019/03/22/blueberry-1553280450594_v2_4x3.jpg");
        cardRepository.save(blueberry);

    // Banana
        Card banana = new Card();
        banana.setName("Banana");
        banana.setRanking(10.0);
        banana.setQtyProteins(1.1);
        banana.setQtyGlucose(62.0);
        banana.setQtyCalories(89.0);
        banana.setUrl("https://www.infoescola.com/wp-content/uploads/2010/04/banana_600797891.jpg");
        cardRepository.save(banana);

    // Cacau
        Card cacau = new Card();
        cacau.setName("Cacau");
        cacau.setRanking(8.0);
        cacau.setQtyProteins(1.8);
        cacau.setQtyGlucose(23.0);
        cacau.setQtyCalories(228.0);
        cacau.setUrl("https://fastcompanybrasil.com/wp-content/uploads/2022/06/Cacau_chocolate_nacional_1_KV.jpg");
        cardRepository.save(cacau);

    // Caqui
        Card caqui = new Card();
        caqui.setName("Caqui");
        caqui.setRanking(6.0);
        caqui.setQtyProteins(0.6);
        caqui.setQtyGlucose(75.0);
        caqui.setQtyCalories(127.0);
        caqui.setUrl("https://cdn.awsli.com.br/600x450/18/18885/produto/146591139/81bacbb61a.jpg");
        cardRepository.save(caqui);

    // Cereja
        Card cereja = new Card();
        cereja.setName("Cereja");
        cereja.setRanking(9.0);
        cereja.setQtyProteins(1.1);
        cereja.setQtyGlucose(22.0);
        cereja.setQtyCalories(50.0);
        cereja.setUrl("https://static3.tcdn.com.br/img/img_prod/350075/muda_de_cereja_europeia_80cm_feita_de_enxerto_6837_1_20220412114219.jpg");
        cardRepository.save(cereja);

    // Coco
        Card coco = new Card();
        coco.setName("Coco");
        coco.setRanking(9.0);
        coco.setQtyProteins(3.3);
        coco.setQtyGlucose(45.0);
        coco.setQtyCalories(354.0);
        coco.setUrl("https://img.freepik.com/fotos-gratis/coco-em-cima-da-mesa_144627-22198.jpg?w=2000");
        cardRepository.save(coco);

    // Framboesa
        Card framboesa = new Card();
        framboesa.setName("Framboesa");
        framboesa.setRanking(9.0);
        framboesa.setQtyProteins(1.2);
        framboesa.setQtyGlucose(3.0);
        framboesa.setQtyCalories(52.0);
        framboesa.setUrl("https://cdn.awsli.com.br/800x800/496/496853/produto/37759414/64e92acd2d.jpg");
        cardRepository.save(framboesa);

    // Goiaba
        Card goiaba = new Card();
        goiaba.setName("Goiaba");
        goiaba.setRanking(5.0);
        goiaba.setQtyProteins(2.6);
        goiaba.setQtyGlucose(78.0);
        goiaba.setQtyCalories(68.0);
        goiaba.setUrl("https://static.tuasaude.com/media/article/1b/bc/beneficios-da-goiaba_13191_l.jpg");
        cardRepository.save(goiaba);

    // Groselha
        Card groselha = new Card();
        groselha.setName("Groselha");
        groselha.setRanking(7.0);
        groselha.setQtyProteins(1.0);
        groselha.setQtyGlucose(25.0);
        groselha.setQtyCalories(45.0);
        groselha.setUrl("https://res.cloudinary.com/compo-com/image/fetch/c_fill,g_xy_center,f_auto,w_472,h_354/https/www.compo.de/.imaging/focus/dam/global/plants/currant-Johannisbeere.jpg/jcr:content.jpeg");
        cardRepository.save(groselha);

    // Jabuticaba
        Card jabuticaba = new Card();
        jabuticaba.setName("Jabuticaba");
        jabuticaba.setRanking(3.0);
        jabuticaba.setQtyProteins(1.5);
        jabuticaba.setQtyGlucose(59.0);
        jabuticaba.setQtyCalories(45.0);
        jabuticaba.setUrl("https://p2.trrsf.com/image/fget/cf/942/530/images.terra.com/2022/10/28/251793143-jabuticaba.jpg");
        cardRepository.save(jabuticaba);

    // Kiwi
        Card kiwi = new Card();
        kiwi.setName("Kiwi");
        kiwi.setRanking(6.0);
        kiwi.setQtyProteins(1.1);
        kiwi.setQtyGlucose(58.0);
        kiwi.setQtyCalories(61.0);
        kiwi.setUrl("https://conteudo.imguol.com.br/c/entretenimento/32/2018/01/18/kiwi-1516301418878_v2_615x300.jpg");
        cardRepository.save(kiwi);

    // Laranja
        Card laranja = new Card();
        laranja.setName("Laranja");
        laranja.setRanking(8.0);
        laranja.setQtyProteins(0.9);
        laranja.setQtyGlucose(43.0);
        laranja.setQtyCalories(47.0);
        laranja.setUrl("https://minhasaude.proteste.org.br/wp-content/uploads/2022/10/muitas-laranjas.png");
        cardRepository.save(laranja);

    // Limão
        Card limao = new Card();
        limao.setName("Limão");
        limao.setRanking(7.0);
        limao.setQtyProteins(0.6);
        limao.setQtyGlucose(24.0);
        limao.setQtyCalories(29.0);
        limao.setUrl("https://www.saudeemdia.com.br/wp-content/uploads/2022/09/beneficios-do-limao-1.jpg");
        cardRepository.save(limao);

    // Maçã
        Card maca = new Card();
        maca.setName("Maçã");
        maca.setRanking(8.0);
        maca.setQtyProteins(0.3);
        maca.setQtyGlucose(39.0);
        maca.setQtyCalories(52.0);
        maca.setUrl("https://conteudo.imguol.com.br/c/entretenimento/6d/2023/01/27/close-up-de-vermelho-maca-royal-gala-1674849210580_v2_900x506.jpg");
        cardRepository.save(maca);

    // Mamão
        Card mamao = new Card();
        mamao.setName("Mamão");
        mamao.setRanking(9.0);
        mamao.setQtyProteins(0.5);
        mamao.setQtyGlucose(60.0);
        mamao.setQtyCalories(43.0);
        mamao.setUrl("https://www.saudeemdia.com.br/antigas/uploads/mamao_widexl.jpg");
        cardRepository.save(mamao);

    // Manga
        Card manga = new Card();
        manga.setName("Manga");
        manga.setRanking(9.0);
        manga.setQtyProteins(0.8);
        manga.setQtyGlucose(60.0);
        manga.setQtyCalories(60.0);
        manga.setUrl("https://static1.minhavida.com.br/ingredients/02/35/8a/07/manga-destaque-orig-1.jpg");
        cardRepository.save(manga);

    // Melão
        Card melao = new Card();
        melao.setName("Melão");
        melao.setRanking(9.0);
        melao.setQtyProteins(0.5);
        melao.setQtyGlucose(65.0);
        melao.setQtyCalories(34.0);
        melao.setUrl("https://conteudo.imguol.com.br/c/entretenimento/f8/2017/12/10/melao-1512917906595_v2_450x450.jpg");
        cardRepository.save(melao);

    // Pêssego
        Card pessego = new Card();
        pessego.setName("Pêssego");
        pessego.setRanking(5.0);
        pessego.setQtyProteins(0.9);
        pessego.setQtyGlucose(42.0);
        pessego.setQtyCalories(39.0);
        pessego.setUrl("https://conteudo.imguol.com.br/c/entretenimento/38/2020/03/30/pessegos-1585605669655_v2_900x506.jpg");
        cardRepository.save(pessego);

    // Pitaya
        Card pitaya = new Card();
        pitaya.setName("Pitaya");
        pitaya.setRanking(1.0);
        pitaya.setQtyProteins(0.7);
        pitaya.setQtyGlucose(5.0);
        pitaya.setQtyCalories(60.0);
        pitaya.setUrl("https://diariodonordeste.verdesmares.com.br/image/contentid/policy:1.3159786:1636999493/pitaya.jpg?f=default&$p$f=34fb41d");
        cardRepository.save(pitaya);
    }
}
