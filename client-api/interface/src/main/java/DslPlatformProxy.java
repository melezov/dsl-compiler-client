//import io.jvm.json.JsonWriter;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.EnumSet;
//import java.util.HashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.TreeSet;
//import java.util.UUID;
//import java.util.concurrent.ExecutorService;
//import java.util.logging.Logger;
//
//import org.slf4j.LoggerFactory;
//
//import com.dslplatform.client.Bootstrap;
//import com.dslplatform.client.CredentialsAuthorization;
//import com.dslplatform.client.DomainProxy;
//import com.dslplatform.client.HttpAuthorization;
//import com.dslplatform.client.serialization.Serialization;
//import com.dslplatform.client.serialization.json.JsonSerialization;
//import com.dslplatform.client.serialization.json.JsonSerializer;
//import com.dslplatform.compiler.client.api.config.ClientConfiguration;
//import com.dslplatform.compiler.client.api.config.ClientConfigurationFactory;
//import com.dslplatform.compiler.client.api.config.PropertyClientConfigurationFactory;
//import com.dslplatform.compiler.client.api.config.PropertyLoader;
//import com.dslplatform.compiler.client.api.config.StreamLoader;
//import com.dslplatform.compiler.client.api.io.HttpRequest;
//import com.dslplatform.compiler.client.api.model.Client.CloneProject;
//import com.dslplatform.compiler.client.api.model.Client.CreateExternalProject;
//import com.dslplatform.compiler.client.api.model.Client.CreateProject;
//import com.dslplatform.compiler.client.api.model.Client.DatabaseConnection;
//import com.dslplatform.compiler.client.api.model.Client.DeleteProject;
//import com.dslplatform.compiler.client.api.model.Client.ProjectDetails;
//import com.dslplatform.compiler.client.api.model.Client.RenameProject;
//import com.dslplatform.compiler.client.api.model.Client.RenameProjectJsonSerialization;
//import com.dslplatform.compiler.client.api.model.Client.WipeCleanProject;
//import com.dslplatform.compiler.client.api.model.Client.repositories.ProjectRepository;
//import com.dslplatform.compiler.client.api.model.Client.repositories.TemplateEvents;
//import com.dslplatform.compiler.client.util.PathExpander;
//import com.dslplatform.patterns.ServiceLocator;
//
//public class DslPlatformProxy {
//    private Logger logger;
//    private final PathExpander pathExpander;
//    private final StreamLoader streamLoader;
//    private final PropertyLoader propertyLoader;
//    private final String configurationPath;
//    private final ClientConfigurationFactory configurationFactory;
//    private final ClientConfiguration clientConfiguration;
//
//    final String username;
//    final char[] password;
//    final String projectIni;
//    private final ByteArrayInputStream bais;
//    private final HttpAuthorization httpAuthorization;
//    private final HttpRequest httpRequest;
//    private final Map<Class<?>,Object> locatorComponents;
//    private final ServiceLocator locator;
//    private final JsonSerialization jsonDeserialization;
//    private final DomainProxy domainProxy;
//    private final ProjectRepository projectRepository;
//    private final TemplateEvents templateEvents;
//
//    public static class Biggy extends BigDecimal {
//        public Biggy() {
//            super(666);
//        }
//    }
//
//    public static class BiggyJsonSerializer implements JsonSerializer<Biggy> {
//        @Override
//        public void toJson(JsonWriter jsonWriter, Biggy value) throws IOException {
//            jsonWriter.writeRaw("XXX-555");
//        }
//    }
//
//    static enum Cards { DIAMONDS, Clubs }
//
//    public static class CarsdsJsonSerializer implements JsonSerializer<Cards> {
//        @Override
//        public void toJson(JsonWriter jsonWriter, Cards value) throws IOException {
//            jsonWriter.writeString(value.name());
//        }
//    }
//
//
//    public DslPlatformProxy(final String username, final String password) throws Exception {
//
//        this.username = username;
//        this.password = password.toCharArray();
//
//        logger = LoggerFactory.getLogger(Main.class);
//        pathExpander = new PathExpander(logger);
//        streamLoader = new StreamLoader(logger, pathExpander);
//        propertyLoader = new PropertyLoader(logger, streamLoader);
//        configurationPath = "/api.properties";
//        configurationFactory = new PropertyClientConfigurationFactory(logger, propertyLoader, configurationPath);
//
//        clientConfiguration = configurationFactory.getClientConfiguration();
//
//        projectIni =
//                "api-url=" + clientConfiguration.getCompilerUri() + "\n"
//                        + "package-name=com.dslplatform.compiler.client.api.model";
//        bais = new ByteArrayInputStream(projectIni.getBytes("ISO-8859-1"));
//
//        httpAuthorization = new CredentialsAuthorization(username, new String(password));
//        httpRequest = new HttpRequest(logger, clientConfiguration, streamLoader, httpAuthorization);
//
//        locatorComponents = new HashMap<Class<?>, Object>();
//        locatorComponents.put(Logger.class, logger);
//        locatorComponents.put(HttpAuthorization.class, httpAuthorization);
//
//        locator = Bootstrap.init(bais, locatorComponents);
//        jsonDeserialization = locator.resolve(JsonSerialization.class);
//
//        domainProxy = locator.resolve(DomainProxy.class);
//        projectRepository = new ProjectRepository(logger, domainProxy, username);
//        templateEvents = new TemplateEvents(logger, domainProxy);
////
//        final RenameProject rp = new RenameProject()
//            .setOldName("EIndex2")
//            .setNewName("EIndex3");
//
//
//
//
//        final Serialization<String> jm = new com.dslplatform.client.serialization.json.JsonSerialization();
//        ((com.dslplatform.client.serialization.json.JsonSerialization) jm).register(RenameProjectJsonSerialization.INSTANCE);
////        ((com.dslplatform.client.serialization.json.JsonSerialization) jm).register(new CarsdsJsonSerializer());
//
//        System.out.println(jm.serialize( new int[][][] { { null, null }, { {}, { 1 }, { 2 }, null } }));
//        System.out.println(jm.serialize( new int[][][] { {}, { {}, { 1 }, { 2 }, null } }));
//        System.out.println(jm.serialize( new int[][][] { { {0} }, { {}, { 1 }, { 2 }, null } }));
//
//
//        System.out.println(jm.serialize(1));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//
//        for (int i = 0; i < 3; i ++ ) {
//            System.out.println(jm.serialize(new ArrayList<Integer>(){{ add(1); add(2); }} ));
//        }
//
//        for (int i = 0; i < 3; i ++ ) {
//            final ArrayList<Integer> a = new ArrayList<Integer>();
//            a.add(10);a.add(20);a.add(30);
//            System.out.println(jm.serialize(a));
//
//            final ArrayList<UUID> u = new ArrayList<UUID>();
//            u.add(UUID.randomUUID());
//            u.add(UUID.randomUUID());
//            System.out.println(jm.serialize(u));
//        }
//
//        System.out.println(jm.serialize(new ArrayList<Integer>(){{ add(1); add(2); }} ));
//        System.out.println(jm.serialize(new ArrayList<Integer>(){{ add(1); add(2); }} ));
//        System.out.println(jm.serialize(new ArrayList<Integer>(){{ add(1); add(2); }} ));
//
//
//
//        final List<Map.Entry<String, Boolean>> ll = (List<Map.Entry<String, Boolean>>) Arrays.asList(
//                (Map.Entry<String, Boolean>) new AbstractMap.SimpleEntry<>("tocno", true),
//                new AbstractMap.SimpleEntry<>("krivo", false),
//                new AbstractMap.SimpleEntry<>("nijedno", (Boolean) null));
//
//        final List<Map.Entry<String, String>> ll2 = (List<Map.Entry<String, String>>) Arrays.asList(
//                (Map.Entry<String, String>) new AbstractMap.SimpleEntry<>("tocno", "trueX"),
//                new AbstractMap.SimpleEntry<>("krivo", "falseX"),
//                new AbstractMap.SimpleEntry<>("nijedno", (String) null));
//
//        System.out.println(jm.serialize(ll));
//        System.out.println(jm.serialize(ll2));
//
//        System.out.println(jm.serialize(ll.toArray(new Map.Entry[ll.size()])));
//        System.out.println(jm.serialize(ll2.toArray(new Map.Entry[ll2.size()])));
//
//
//        System.out.println(jm.serialize(1));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//        System.out.println(jm.serialize(new Integer[] { 1, 2} ));
//        System.out.println(jm.serialize(new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() } ));
//
//
//        final Map<String, String> m = new TreeMap<String, String>() {{ }};
//
//        if (Map.class.isAssignableFrom(m.getClass())) {
//            System.out.println("its ok");
//        }
//
//        System.out.println(jm.serialize(m));
//
//
//        System.out.println(jm.serialize(new Map[] { }));
//
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ }} ));
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ put("a", "1"); }} ));
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ put("a", "1"); put("b", "2"); }} ));
//
//
//        System.out.println(jm.serialize(Cards.DIAMONDS));
//        System.out.println(jm.serialize(Cards.Clubs));
//
//        System.out.println(jm.serialize(new Cards[] { Cards.Clubs, Cards.Clubs } ));
//        System.out.println(jm.serialize(EnumSet.allOf(Cards.class)));
//
//
//        System.out.println(jm.serialize(rp));
//        System.out.println(jm.serialize(new RenameProject[] { rp, rp, rp }));
//        System.out.println(jm.serialize(new ArrayList<RenameProject>() {{ add(rp); add(rp); }} ));
//        System.out.println(jm.serialize(new LinkedHashSet<RenameProject>() {{ add(rp); add(rp); add(rp); add(rp); }} ));
//        System.out.println(jm.serialize(new boolean[] { true, true, false } ));
//        System.out.println(jm.serialize(true));
//        System.out.println(jm.serialize("IT IS DA \"TRUT\"!"));
//
//        System.out.println(jm.serialize(1));
//        System.out.println(jm.serialize(Integer.valueOf(2)));
//        System.out.println(jm.serialize(new int[] { 3, 4 } ));
//        System.out.println(jm.serialize(new Integer[] { 5, 6 } ));
//        System.out.println(jm.serialize(new ArrayList<Integer>() {{ add(7); add(8); }} ));
//        System.out.println(jm.serialize(new TreeSet<Integer>() {{ add(9); add(10); }} ));
//
//        System.out.println(jm.serialize(new Biggy()));
//        System.out.println(jm.serialize(new Biggy[] {}));
//        System.out.println(jm.serialize(new Biggy[] { new Biggy(),new Biggy(),new Biggy() } ));
//        System.out.println(jm.serialize(new ArrayList<Biggy>() {{ add(new Biggy()); add(new Biggy()); }} ));
//
//        ((com.dslplatform.client.serialization.json.JsonSerialization) jm).register(new BiggyJsonSerializer());
//
//        System.out.println(jm.serialize(new Biggy()));
//        System.out.println(jm.serialize(new Biggy[] {}));
//        System.out.println(jm.serialize(new Biggy[] { new Biggy(),new Biggy(),new Biggy() } ));
//        System.out.println(jm.serialize(new ArrayList<Biggy>() {{ add(new Biggy()); add(new Biggy()); }} ));
//
//        System.out.println(jm.serialize(new Map[] { }));
//
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ }} ));
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ put("a", "1"); }} ));
//        System.out.println(jm.serialize(new TreeMap<String, String>() {{ put("a", "1"); put("b", "2"); }} ));
//
//        System.out.println(jm.serialize(new Map[] { new TreeMap<String, String>() {{ }} } ));
//        System.out.println(jm.serialize(new Map[] { new TreeMap<String, String>() {{ put("a", "1"); }} } ));
//        System.out.println(jm.serialize(new Map[] { new TreeMap<String, String>() {{ put("a", "1"); put("b", "2"); }} } ));
//
//
//        System.exit(0);
//
////        final JsonSerializationImpl jm = new JsonSerializationImpl(locator);
////        jm.register(RenameProjectJsonSerialization.class);
////        jm.register(ProjectJsonDeserialization.class);
//
//        final String bodyArr = "[{'ID':'6317ae03-c495-4f9a-b0c7-f764472207df','UserID':'marko@element.hr','CreatedAt':'2014-02-20T18:06:07.978391+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_b903d07c2047f2885e598f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_b903d07c2047f2885e598f','ApplicationPoolName':'beta_b903d07c2047f2885e598f','Nick':'SimonDemo','URI':'6317ae03-c495-4f9a-b0c7-f764472207df','UserURI':'marko@element.hr'},{'ID':'b06f7bd7-f3ad-4383-834a-ed42250b4d81','UserID':'marko@element.hr','CreatedAt':'2014-02-18T05:45:27.649201+01:00','DatabaseServer':'10.5.17.1','DatabasePort':5432,'DatabaseName':'extest_00','ApplicationServer':'localhost','ApplicationName':'extest','ApplicationPoolName':'beta_b2ca79c5304a99888b5113','Nick':'extest','CustomDatabaseAdmin':'extest','CustomDatabasePassword':'extest3000','IsExternal':true,'URI':'b06f7bd7-f3ad-4383-834a-ed42250b4d81','UserURI':'marko@element.hr'},{'ID':'15e5faac-2e9e-4da2-91a3-543982cc256f','UserID':'marko@element.hr','CreatedAt':'2014-02-18T03:52:24.523886+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_14a79f5b59400987ef4425','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_14a79f5b59400987ef4425','ApplicationPoolName':'beta_14a79f5b59400987ef4425','Nick':'GreenKouprey','URI':'15e5faac-2e9e-4da2-91a3-543982cc256f','UserURI':'marko@element.hr'},{'ID':'1ebf04dd-268a-451c-b78e-7cf8f2f9a2f2','UserID':'marko@element.hr','CreatedAt':'2014-02-12T15:06:58.665532+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_66312aba24472fb52a575f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_66312aba24472fb52a575f','ApplicationPoolName':'beta_66312aba24472fb52a575f','Nick':'MaliERP','URI':'1ebf04dd-268a-451c-b78e-7cf8f2f9a2f2','UserURI':'marko@element.hr'},{'ID':'63812f35-548d-4cad-8f1a-7f2534a7c687','UserID':'marko@element.hr','CreatedAt':'2014-02-10T17:04:18.286375+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_8b633ad3c549c0a8f3b778','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_8b633ad3c549c0a8f3b778','ApplicationPoolName':'beta_8b633ad3c549c0a8f3b778','Nick':'NgsUtilClient','URI':'63812f35-548d-4cad-8f1a-7f2534a7c687','UserURI':'marko@element.hr'},{'ID':'3b3e1ec0-bdf3-46a7-a08a-eaa99528c2c7','UserID':'marko@element.hr','CreatedAt':'2014-01-30T00:44:46.855651+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_9aca26514249aaaa17d01e','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_9aca26514249aaaa17d01e','ApplicationPoolName':'beta_9aca26514249aaaa17d01e','Nick':'CyanWoodpecker','URI':'3b3e1ec0-bdf3-46a7-a08a-eaa99528c2c7','UserURI':'marko@element.hr'},{'ID':'5ef20bb0-3b70-4466-8c22-0a32942adfe6','UserID':'marko@element.hr','CreatedAt':'2014-01-25T01:49:44.564978+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_0d712988e440018612ce51','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_0d712988e440018612ce51','ApplicationPoolName':'beta_0d712988e440018612ce51','Nick':'WhiteCheetah','URI':'5ef20bb0-3b70-4466-8c22-0a32942adfe6','UserURI':'marko@element.hr'},{'ID':'2f718abf-667c-4b38-94bd-8752daba2fd6','UserID':'marko@element.hr','CreatedAt':'2014-01-21T17:33:46.242832+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_7ef1d9208644f8b94b2924','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_7ef1d9208644f8b94b2924','ApplicationPoolName':'beta_7ef1d9208644f8b94b2924','Nick':'SilverShrew','URI':'2f718abf-667c-4b38-94bd-8752daba2fd6','UserURI':'marko@element.hr'},{'ID':'10faae1c-e3db-4e67-ad20-a931b784b38c','UserID':'marko@element.hr','CreatedAt':'2014-01-20T03:48:26.276495+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_590bd1d6d142e7aa8995b4','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_590bd1d6d142e7aa8995b4','ApplicationPoolName':'beta_590bd1d6d142e7aa8995b4','Nick':'YellowSpider','URI':'10faae1c-e3db-4e67-ad20-a931b784b38c','UserURI':'marko@element.hr'},{'ID':'b0353d6e-8968-4488-a046-4882e6cd6de3','UserID':'marko@element.hr','CreatedAt':'2014-01-08T18:24:25.250126+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_66b85af7c84cda84b0f410','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_66b85af7c84cda84b0f410','ApplicationPoolName':'beta_66b85af7c84cda84b0f410','Nick':'MindBlank','URI':'b0353d6e-8968-4488-a046-4882e6cd6de3','UserURI':'marko@element.hr'},{'ID':'819286e1-c6bb-4b10-8a5f-664aa02a1339','UserID':'marko@element.hr','CreatedAt':'2013-12-26T12:17:04.821771+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_ccda32b2fd4e1187b59879','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_ccda32b2fd4e1187b59879','ApplicationPoolName':'beta_ccda32b2fd4e1187b59879','Nick':'ScalaSeconder','URI':'819286e1-c6bb-4b10-8a5f-664aa02a1339','UserURI':'marko@element.hr'},{'ID':'09779f1b-505e-4464-ba02-272877123467','UserID':'marko@element.hr','CreatedAt':'2013-12-26T08:35:48.048651+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_d83f6026044faa90bd9a23','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_d83f6026044faa90bd9a23','ApplicationPoolName':'beta_d83f6026044faa90bd9a23','Nick':'ScalaPrimer','URI':'09779f1b-505e-4464-ba02-272877123467','UserURI':'marko@element.hr'},{'ID':'cb02db1c-beb0-4745-a5e1-d4367d66ea4c','UserID':'marko@element.hr','CreatedAt':'2013-12-04T18:11:16.389527+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_114e4953734dc5a816d133','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_114e4953734dc5a816d133','ApplicationPoolName':'beta_114e4953734dc5a816d133','Nick':'Adept','URI':'cb02db1c-beb0-4745-a5e1-d4367d66ea4c','UserURI':'marko@element.hr'},{'ID':'40a2406a-f9d4-418f-a18e-f5bb8ad333ce','UserID':'marko@element.hr','CreatedAt':'2013-12-02T17:35:35.919461+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_045f0d549046d4ad14dd97','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_045f0d549046d4ad14dd97','ApplicationPoolName':'beta_045f0d549046d4ad14dd97','Nick':'USHR','URI':'40a2406a-f9d4-418f-a18e-f5bb8ad333ce','UserURI':'marko@element.hr'},{'ID':'1fc5b445-45db-4703-9539-7c08a0b33459','UserID':'marko@element.hr','CreatedAt':'2013-12-02T15:17:30.042907+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c1fac3b78845f3a174c0d8','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c1fac3b78845f3a174c0d8','ApplicationPoolName':'beta_c1fac3b78845f3a174c0d8','Nick':'ScalaExchange','URI':'1fc5b445-45db-4703-9539-7c08a0b33459','UserURI':'marko@element.hr'},{'ID':'7e6a6480-a2bd-41b7-bd35-81759de2b563','UserID':'marko@element.hr','CreatedAt':'2013-11-29T16:50:17.725247+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_fc6961eea04246a0882e52','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_fc6961eea04246a0882e52','ApplicationPoolName':'beta_fc6961eea04246a0882e52','Nick':'OrangeHippopotamus','URI':'7e6a6480-a2bd-41b7-bd35-81759de2b563','UserURI':'marko@element.hr'},{'ID':'93964af8-83d5-4b5a-ac70-d27f48b96125','UserID':'marko@element.hr','CreatedAt':'2013-11-28T14:20:09.283671+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_623f8ae48b4ed7b00bc6c9','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_623f8ae48b4ed7b00bc6c9','ApplicationPoolName':'beta_623f8ae48b4ed7b00bc6c9','Nick':'ScarletNightingale','URI':'93964af8-83d5-4b5a-ac70-d27f48b96125','UserURI':'marko@element.hr'},{'ID':'803307fd-41a0-47a4-ae44-5e2485ccb4e7','UserID':'marko@element.hr','CreatedAt':'2013-11-28T11:29:25.229278+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c85cdc16c14464b4c87a2b','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c85cdc16c14464b4c87a2b','ApplicationPoolName':'beta_c85cdc16c14464b4c87a2b','Nick':'InfinumDemo','URI':'803307fd-41a0-47a4-ae44-5e2485ccb4e7','UserURI':'marko@element.hr'},{'ID':'afba6959-e1a4-47c6-aa31-53a7d420ab1d','UserID':'marko@element.hr','CreatedAt':'2013-11-26T22:13:59.110774+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_98ab6e5b9e4764becd6e64','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_98ab6e5b9e4764becd6e64','ApplicationPoolName':'beta_98ab6e5b9e4764becd6e64','Nick':'VioletPanther','URI':'afba6959-e1a4-47c6-aa31-53a7d420ab1d','UserURI':'marko@element.hr'},{'ID':'130fee97-fa2c-4c66-a84a-edb0ce78ad26','UserID':'marko@element.hr','CreatedAt':'2013-11-26T22:13:48.205354+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_c193c155174b2ca1a24671','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_c193c155174b2ca1a24671','ApplicationPoolName':'beta_c193c155174b2ca1a24671','Nick':'Test1','URI':'130fee97-fa2c-4c66-a84a-edb0ce78ad26','UserURI':'marko@element.hr'},{'ID':'8124eb6d-c71a-41a4-a93f-d734cb7471db','UserID':'marko@element.hr','CreatedAt':'2013-11-26T17:18:00.463981+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_11522cd239425f97d759c9','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_11522cd239425f97d759c9','ApplicationPoolName':'beta_11522cd239425f97d759c9','Nick':'ElemicaDemo','URI':'8124eb6d-c71a-41a4-a93f-d734cb7471db','UserURI':'marko@element.hr'},{'ID':'f6f6c06c-c458-4198-ad92-78eb54c63d56','UserID':'marko@element.hr','CreatedAt':'2013-11-22T18:25:11.783123+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_1715f531d94dd786711093','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_1715f531d94dd786711093','ApplicationPoolName':'beta_1715f531d94dd786711093','Nick':'nautic','URI':'f6f6c06c-c458-4198-ad92-78eb54c63d56','UserURI':'marko@element.hr'},{'ID':'24c02e84-c77e-4b32-bca6-f8968620effc','UserID':'marko@element.hr','CreatedAt':'2013-07-05T10:52:49.686308+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'alpha_8c08654b384feea9826476','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'alpha_8c08654b384feea9826476','ApplicationPoolName':'alpha_8c08654b384feea9826476','Nick':'EIndex3','URI':'24c02e84-c77e-4b32-bca6-f8968620effc','UserURI':'marko@element.hr'}]";
//        final String body = "{'ID':'6317ae03-c495-4f9a-b0c7-f764472207df','UserID':'marko@element.hr','CreatedAt':'2014-02-20T18:06:07.978391+01:00','DatabaseServer':'postgres.dsl-platform.com','DatabasePort':6433,'DatabaseName':'beta_b903d07c2047f2885e598f','ApplicationServer':'node0.dsl-platform.com','ApplicationName':'beta_b903d07c2047f2885e598f','ApplicationPoolName':'beta_b903d07c2047f2885e598f','Nick':'SimonDemo','URI':'6317ae03-c495-4f9a-b0c7-f764472207df','UserURI':'marko@element.hr'}";
//
////        {
////            final Project[] projects = jm.fromJson(bodyArr.replace('\'', '"'), Project[].class);
////            System.out.println(projects.length);
////        }
//
////        final Collection<Project> projects = jm.fromJson(bodyArr.replace('\'', '"'), Project.class, new LinkedHashSet<Project>());
//
////        System.out.println(projects);
//
////        final ProjectDetails pd = projectRepository.getProject("EIndex");
////        System.out.println(pd);
//
//        System.out.println(rp.getURI());
//
//        {
//            final long startedAt = System.currentTimeMillis();
//            for (int i = 0; i < 1; i ++) {
//                    JsonSerialization.serialize(rp);
//            }
//            final long endedAt = System.currentTimeMillis();
//            System.out.println((endedAt - startedAt) + " ms");
//        }
//
////        {
////            final long startedAt = System.currentTimeMillis();
////            for (int i = 0; i < 1; i ++) {
////                    jm.toJson(rp);
////            }
////            final long endedAt = System.currentTimeMillis();
////            System.out.println((endedAt - startedAt) + " ms");
////        }
////
////        System.out.println(jm.toJson(rp));
//        projectRepository.getProjects();
//        System.exit(0);
//        rp.submit(locator);
//
//        System.out.println(rp.getURI());
//        {
//            System.out.println(JsonSerialization.serialize(rp));
////            System.out.println(jm.toJson(rp));
//        }
//
//
//        System.exit(0);
//    }
//
//    public ProjectDetails getProjectByName(final String projectName) throws Exception {
//        return projectRepository.getProject(projectName);
//    }
//
//    public String doClean(final String project) throws Exception {
//        final WipeCleanProject wcpEvent = new WipeCleanProject(project);
//        return wcpEvent.submit(locator);
//    }
//
//    public String doCreate(final String name) throws Exception {
//        final CreateProject cpEvent = new CreateProject(name);
//        return cpEvent.submit(locator);
//    }
//
//    public String doCreateExternalProject(final String name, final String serverName, final String applicationName, final DatabaseConnection dbc) throws Exception{
//        final CreateExternalProject cepEvent = new CreateExternalProject(name, serverName, applicationName, dbc);
//        return cepEvent.submit(locator);
//    }
//
//    public String doCloneProject(final String name) throws Exception {
//        final CloneProject cpEvent = new CloneProject(name);
//        return cpEvent.submit(locator);
//    }
//
//    public String doDeleteProject(final String name) throws Exception {
//        final DeleteProject cpEvent = new DeleteProject(name);
//        return cpEvent.submit(locator);
//    }
//
//    public String generateMigrationSQL(final String projectName) throws Exception {
//        throw new Exception("Not Implemented Yet!");
//    }
////
////    public void doThatFirstThing() throws Exception {
////        final Logger logger = LoggerFactory.getLogger(Main.class);
////        final PathExpander pathExpander = new PathExpander(logger);
////        final StreamLoader streamLoader = new StreamLoader(logger, pathExpander);
////        final PropertyLoader propertyLoader = new PropertyLoader(logger, streamLoader);
////        final String configurationPath = "/api.properties";
////        final ClientConfigurationFactory configurationFactory =
////                new PropertyClientConfigurationFactory(logger, propertyLoader, configurationPath);
////
////        final ClientConfiguration clientConfiguration = configurationFactory.getClientConfiguration();
////
////        final String projectIni =
////                "api-url=" + clientConfiguration.getCompilerUri() + "\n"
////                        + "package-name=com.dslplatform.compiler.client.api.model";
////        final ByteArrayInputStream bais = new ByteArrayInputStream(projectIni.getBytes("ISO-8859-1"));
////
////        final HttpAuthorization httpAuthorization = new CredentialsAuthorization(username, new String(password));
////        final HttpRequest httpRequest = new HttpRequest(logger, clientConfiguration, streamLoader, httpAuthorization);
////
////        final Map<Class<?>, Object> locatorComponents = new HashMap<Class<?>, Object>();
////        locatorComponents.put(Logger.class, logger);
////        locatorComponents.put(HttpAuthorization.class, httpAuthorization);
////
////        final ServiceLocator locator = Bootstrap.init(bais, locatorComponents);
////        final JsonSerialization jsonDeserialization = locator.resolve(JsonSerialization.class);
////
////        {
////            final Request request =
////                    httpRequest.builder(Method.PUT, "parse").setBody("{\"a.dsl\":\"module a; xXx\"}".getBytes("UTF-8"));
////            httpRequest.sendRequest(request);
////        }
////
////        final DomainProxy domainProxy = locator.resolve(DomainProxy.class);
////        final ProjectRepository projectRepository = new ProjectRepository(logger, domainProxy, username);
////        final TemplateEvents templateEvents = new TemplateEvents(logger, domainProxy);
////
////        final ProjectDetails projectDetails = projectRepository.getProject("BlackFish");
////
////        {
////            final Request request = httpRequest.builder(Method.GET, "dsl/" + projectDetails.getID());
////
////            final Response response = httpRequest.sendRequest(request);
////            jsonDeserialization.deserialize(JsonSerialization.buildGenericType(LinkedHashMap.class, String.class,
////                    String.class), new String(response.getBody(), "UTF-8"));
////        }
////
////        {
////            final Request request = httpRequest.builder(Method.GET, "generated-model/" + projectDetails.getID());
////            httpRequest.sendRequest(request);
////        }
////
////        {
////            final Request request = httpRequest.builder(Method.GET, "download/" + projectDetails.getID());
////            httpRequest.sendRequest(request);
////        }
////
////        {
////            templateEvents.upload(projectDetails.getID(), "keke.docx", "Fake DOCX!".getBytes("UTF-8"));
////        }
////
////        {
////            final Request request = httpRequest.builder(Method.GET, "templates/" + projectDetails.getID());
////            final Response response = httpRequest.sendRequest(request);
////
////            System.out.println(new String(response.getBody()));
////        }
////
////        {
////            final Request request =
////                    httpRequest.builder(Method.GET, "template/" + projectDetails.getID() + "/keke.docx");
////            final Response response = httpRequest.sendRequest(request);
////
////            final String content =
////                    new String(Base64.decodeBase64(((String) jsonDeserialization.deserialize(
////                            JsonSerialization.buildType(String.class), new String(response.getBody(), "UTF-8")))
////                            .getBytes("UTF-8")), "UTF-8");
////
////            System.out.println(content);
////        }
////
////        {
////            templateEvents.delete(projectDetails.getID(), "keke.docx");
////        }
////
////        {
////            final Request request =
////                    httpRequest
////                            .builder(
////                                    Method.POST,
////                                    "update/"
////                                            + projectDetails.getID()
////                                            + "?targets=Java,ScalaClient&namespace=test.update&migration=unsafe&options=with-active-record")
////                            .setBody("{\"a.dsl\":\"module Foo { root Bar { } }\"}".getBytes("UTF-8"));
////
////            final Response response = httpRequest.sendRequest(request);
////
////            jsonDeserialization.deserialize(JsonSerialization.buildGenericType(LinkedHashMap.class, String.class,
////                    String.class), new String(response.getBody(), "UTF-8"));
////        }
////
////        {
////            final Request request =
////                    httpRequest.builder(Method.GET, "source/" + projectDetails.getID()
////                            + "?targets=PHP&namespace=test.source&options=with-active-record");
////
////            final Response response = httpRequest.sendRequest(request);
////            jsonDeserialization.deserialize(JsonSerialization.buildGenericType(LinkedHashMap.class, String.class,
////                    String.class), new String(response.getBody(), "UTF-8"));
////        }
////
////        {
////            final Request request =
////                    httpRequest.builder(Method.PUT, "changes/" + projectDetails.getID()).setBody(
////                            "{\"a.dsl\":\"module Foo { root Xyz; }\"}".getBytes("UTF-8"));
////
////            final Response response = httpRequest.sendRequest(request);
////            System.out.println(new String(response.getBody()));
////        }
////
////        {
////            final Request request =
////                    httpRequest.builder(Method.GET, "config/" + projectDetails.getID()
////                            + "?targets=PHP,Java,CSharp,Scala&namespace=test.config");
////
////            final Response response = httpRequest.sendRequest(request);
////            System.out.println(jsonDeserialization.deserialize(JsonSerialization.buildGenericType(LinkedHashMap.class, String.class,
////                    String.class), new String(response.getBody(), "UTF-8"))
////            );
////        }
////    }
//
//    public void shutdown() {
//        locator.resolve(ExecutorService.class);
//    }
//}
