package carson.spellinghelp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mText;
    private ArrayList<String> mWords = new ArrayList<String>();

    private Button correctButton;
    private Button incorrectButton;
    private int index = -1;
    private String allWords;
    private EditText editText;
    private Button submit;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.included_layout);
        setWords();
        mText = (TextView) v.findViewById(R.id.textView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        correctButton = (Button) v.findViewById(R.id.correct_button);
        incorrectButton = (Button) v.findViewById(R.id.incorrect_button);
        info = (TextView) v.findViewById(R.id.correct);
        info.setVisibility(View.GONE);
        editText = (EditText) v.findViewById(R.id.editText);
        submit = (Button) v.findViewById(R.id.submit);
        editText.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        setOnClicks();
        setSupportActionBar(toolbar);
        final Random generator = new Random();
        popStringArr();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                index = generator.nextInt(mWords.size());
                mText.setText(mWords.get(index));
            }
        });
    }


    private void popStringArr() {
        for (int i = 0; i < allWords.length(); i++) {
            String oneWord = "";
            int j = i;
            while (endWhileLoop(j, allWords)) {
                oneWord += allWords.charAt(j);
                j++;
            }
            i = j;
            mWords.add(oneWord);
        }
    }

    private boolean endWhileLoop(int index, String words) {
        if (index < words.length()) {
            if (words.charAt(index) != '\n' && words.charAt(index) != ' ') {
                return true;
            }
        }
        return false;
    }

    private void setOnClicks() {
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > -1) {
                    String text;
                    info.setVisibility(View.VISIBLE);
                    if (index < 407) {
                        text = "Correct!";
                    } else {
                        text = "Incorrect";
                    }
                    info.setText(text);
                }
            }
        });

        incorrectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > -1) {
                    String text;
                    info.setVisibility(View.VISIBLE);
                    if (index < 407) {
                        text = "Incorrect";
                    } else {
                        text = "Correct!";
                    }
                    if (text.equals("Correct!")) {
                        editText.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                    }
                    info.setText(text);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String submitted = editText.getText().toString();
                String text = "";
                for (int i = 0; i < 407; i++) {
                    if (submitted.equals(mWords.get(i))) {
                        text = "Spelled Correctly!";
                        break;
                    }
                }
                if (text.equals("")) {
                    text = "Try again";
                }
                info.setText(text);
            }
        });
    }

    private void setWords() {
        allWords = "abandon application changeable dessert expensive\n" +
                "abbreviate approach chief desperate extraordinary\n" +
                "absence appropriate chocolate develop extremely\n" +
                "absorption approximate choose development facsimile\n" +
                "accelerate approximately collaborate device familiar\n" +
                "accent argue colleague diagnose fascinate\n" +
                "acceptance argument column difference fasten\n" +
                "accessible arrogant coming different February\n" +
                "accident assault committee disappearance finally\n" +
                "acclaim assessment commission disappoint foreign\n" +
                "accommodate assign competition disastrous foreigner\n" +
                "accumulate association competent discipline forfeit\n" +
                "accuracy assume completely discussed formerly\n" +
                "accurate athlete compose disgust fortunately\n" +
                "accuse atmosphere conceal disillusioned forty\n" +
                "achieve attempt conceive dissatisfied further\n" +
                "achievement audible confidence divide gauge\n" +
                "across audience confidential drunkenness government\n" +
                "addict authoritative congratulations dying grammar\n" +
                "additional authorize conscience echoes grateful\n" +
                "address awkward conscious efficient grievance\n" +
                "adjourn automatically consistent eight guarantee\n" +
                "advertise becoming conspiracy elaborate harassment\n" +
                "advise beginner continuing eliminate height\n" +
                "affidavit beginning continuous embarrassed humorous\n" +
                "aging belief controversial encourage hurriedly\n" +
                "allege benefit convenient enough hysterical\n" +
                "already benefited convulsion enterprise identical\n" +
                "altogether boundary correspondence environment illegal\n" +
                "always Britain counselor equipment illegible\n" +
                "amateur bulletin courteous erratic illustrate\n" +
                "among burglar criticism erupt imaginary\n" +
                "analysis burglaries criticize ethical immediately\n" +
                "analyze calendar debt especially imminent\n" +
                "ancient cancelled deceased evidence impartial\n" +
                "announce candidate decision evident incoherent\n" +
                "annoyance canoeing definite excellent inconvenient\n" +
                "anonymous cashier definitely exercise independent\n" +
                "antidote casual deliberate exhausted\n" +
                "inevitable\n" +
                "inflammable\n" +
                "apartment ceiling dependent exhibit influence\n" +
                "apparent cemetery description existence injuries\n" +
                "appliance certain designate expense innocent\n" +
                "inquiry molester opportunity repetitive supplement\n" +
                "intelligence muscle phoney require surprise\n" +
                "interest mysterious physically resistance suspense\n" +
                "interfere necessary pleasant restaurant taillight\n" +
                "interpretation negligence possess rhythm technique\n" +
                "interrupt neither possession ridiculous temperature\n" +
                "intoxicate neutral possible rigorous temporarily\n" +
                "involved niece possibly roommate therefore\n" +
                "irate nineteen potato sabotage thief\n" +
                "irresistible ninth preferred sacrifice thoroughly\n" +
                "itinerary no one prejudice safety though\n" +
                "jealous noticeable presume satisfying thought\n" +
                "jewellery nuclear prevalent schedule tragedy\n" +
                "knowledgeable obedient primary scissors transferred\n" +
                "legal occurred probably secretary transient\n" +
                "legitimate occurrence procedure seize traveled\n" +
                "leisure omission professor senior tried\n" +
                "length omitted prominent sense tries\n" +
                "lenient opinion pronunciation separate truly\n" +
                "lethal optimism prove sequence twelfth\n" +
                "liable ordinarily provoke severe tying\n" +
                "likeable original psychology severely unfortunately\n" +
                "likely paid pursue shining until\n" +
                "livelihood parallel putting significant unusual\n" +
                "logical parliament quantity similar usage\n" +
                "lovely particular questionnaire sincerely useful\n" +
                "mandatory patient readily solicit useless\n" +
                "maintenance peculiar reality someone using\n" +
                "marriage pedestrian recede species utilize\n" +
                "mathematics penetrate receipt specimen valuable\n" +
                "mattress perform recognized speech variety\n" +
                "mature permanent recommend stopping vegetable\n" +
                "meant permanently preceding straight vehicle\n" +
                "medicine persevere privilege strength villain\n" +
                "merchandise personal regular studying warrant\n" +
                "miniature personality relevant subsequent whether\n" +
                "minimal personnel relieve success writing\n" +
                "minimize persuade religious suffocate written\n" +
                "miscellaneous occasion rescind superintendent you're" + "abanden\n" +
                "abreviate\n" +
                "abbriviate\n" +
                "absorpshon\n" +
                "absorpton\n" +
                "acelerate\n" +
                "accelrate\n" +
                "acent\n" +
                "accennt\n" +
                "aceptance\n" +
                "acceptence\n" +
                "acesible\n" +
                "accesible\n" +
                "acessible\n" +
                "accessable\n" +
                "acident\n" +
                "accidant\n" +
                "aclaim\n" +
                "acclame\n" +
                "acomodate\n" +
                "accommodate\n" +
                "accommadate\n" +
                "accomadate\n" +
                "acumulate\n" +
                "accumelate\n" +
                "acuracy\n" +
                "accuracey\n" +
                "accureacy\n" +
                "acurate\n" +
                "acuse\n" +
                "acheive\n" +
                "acheivement\n" +
                "achievment\n" +
                "accross\n" +
                "adict\n" +
                "aditional\n" +
                "additionel\n" +
                "adress\n" +
                "addres\n" +
                "ajourn\n" +
                "adjurn\n" +
                "advertize\n" +
                "advize\n" +
                "afidavit\n" +
                "affidavite\n" +
                "afidavite\n" +
                "ageing\n" +
                "alledge\n" +
                "allready\n" +
                "alreadey\n" +
                "alltogether\n" +
                "allways\n" +
                "amature\n" +
                "amonng\n" +
                "analisis\n" +
                "analize\n" +
                "analyse\n" +
                "analyzis\n" +
                "anshient\n" +
                "ancent\n" +
                "anounce\n" +
                "announnce\n" +
                "anoyance\n" +
                "annoyence\n" +
                "anonemous\n" +
                "anonymos\n" +
                "antidot\n" +
                "aparpment\n" +
                "aparent\n" +
                "aplication\n" +
                "applicaton\n" +
                "aproach\n" +
                "approch\n" +
                "apropriate\n" +
                "approppriate\n" +
                "aproximate\n" +
                "approximat\n" +
                "aproximatly\n" +
                "approximatly\n" +
                "arrgue\n" +
                "arguement\n" +
                "arrogent\n" +
                "arogant\n" +
                "asault\n" +
                "assolt\n" +
                "asesment\n" +
                "assesment\n" +
                "asessment\n" +
                "assessmant\n" +
                "asign\n" +
                "assine\n" +
                "assigne\n" +
                "assosiation\n" +
                "asociation\n" +
                "asume\n" +
                "athelete\n" +
                "atemosphere\n" +
                "atmosfere\n" +
                "atempt\n" +
                "attemt\n" +
                "audable\n" +
                "adible\n" +
                "audience\n" +
                "audiense\n" +
                "authoratative\n" +
                "athoritative\n" +
                "authorititive\n" +
                "authorise\n" +
                "athorise\n" +
                "akward\n" +
                "awkwerd\n" +
                "automaticly\n" +
                "automaticaly\n" +
                "automaticalley\n" +
                "becomeing\n" +
                "beginer\n" +
                "begining\n" +
                "beleif\n" +
                "benifit\n" +
                "benifited\n" +
                "benefitted\n" +
                "boundry\n" +
                "boundrey\n" +
                "britain\n" +
                "britin\n" +
                "bullitin\n" +
                "bulleten\n" +
                "burgurler\n" +
                "burgelar\n" +
                "burgelaries\n" +
                "burgleries\n" +
                "calender\n" +
                "canceled\n" +
                "candidite\n" +
                "canoing\n" +
                "casheir\n" +
                "casheer\n" +
                "cashual\n" +
                "cassual\n" +
                "cieling\n" +
                "cemetary\n" +
                "cematery\n" +
                "changable\n" +
                "cheif\n" +
                "choclate\n" +
                "chocolat\n" +
                "chocalate\n" +
                "chocolete\n" +
                "choos\n" +
                "chooze\n" +
                "colaborate\n" +
                "collaborrate\n" +
                "collaberate\n" +
                "colabarate\n" +
                "coleague\n" +
                "colleage\n" +
                "columm\n" +
                "colum\n" +
                "comin\n" +
                "cuming\n" +
                "comittee\n" +
                "commitee\n" +
                "committe\n" +
                "comission\n" +
                "commision\n" +
                "comision\n" +
                "compatition\n" +
                "compitition\n" +
                "competant\n" +
                "compatent\n" +
                "compeletely\n" +
                "completeley\n" +
                "compoze\n" +
                "conseal\n" +
                "conceel\n" +
                "conseel\n" +
                "concieve\n" +
                "consieve\n" +
                "confidance\n" +
                "confedence\n" +
                "condadence\n" +
                "confadential\n" +
                "congradulations\n" +
                "consiounse\n" +
                "consiounce\n" +
                "consious\n" +
                "conscous\n" +
                "consistant\n" +
                "conspiracey\n" +
                "continueing\n" +
                "contineuous\n" +
                "contraversial\n" +
                "conveneint\n" +
                "conveniete\n" +
                "convulshion\n" +
                "corespondance\n" +
                "correspondance\n" +
                "corespondence\n" +
                "counseler\n" +
                "counsaler\n" +
                "courtous\n" +
                "critisism\n" +
                "critisize\n" +
                "critisise\n" +
                "det\n" +
                "deseased\n" +
                "deceesed\n" +
                "desision\n" +
                "definate\n" +
                "definete\n" +
                "delibrate\n" +
                "dependant\n" +
                "discription\n" +
                "discreption\n" +
                "desert (sweet treat)\n" +
                "desprate\n" +
                "desperete\n" +
                "develope\n" +
                "developement\n" +
                "divice\n" +
                "diagnoss\n" +
                "diference\n" +
                "diffrence\n" +
                "differance\n" +
                "diferent\n" +
                "diffrent\n" +
                "differant\n" +
                "dissappearence\n" +
                "disappearence\n" +
                "dissappearance\n" +
                "disapoint\n" +
                "dissappoint\n" +
                "disasterous\n" +
                "disipline\n" +
                "discused\n" +
                "discust\n" +
                "disguste\n" +
                "disallusioned\n" +
                "disilussioned\n" +
                "disillussioned\n" +
                "disattisfied\n" +
                "disatisfied\n" +
                "devide\n" +
                "drunkeness\n" +
                "dyeing (to die)\n" +
                "echos\n" +
                "ecoes\n" +
                "efficeint\n" +
                "eficient\n" +
                "effecient\n" +
                "eght\n" +
                "elaberate\n" +
                "elimenate\n" +
                "eleminate\n" +
                "embarassed\n" +
                "embarrased\n" +
                "emberassed\n" +
                "encorage\n" +
                "enncourage\n" +
                "enouff\n" +
                "enterprize\n" +
                "enviroment\n" +
                "envirenment\n" +
                "equiptment\n" +
                "equipmant\n" +
                "eratic\n" +
                "errupt\n" +
                "erupte\n" +
                "ethicall\n" +
                "ethecal\n" +
                "especialey\n" +
                "especialy\n" +
                "especialley\n" +
                "espesially\n" +
                "evidance\n" +
                "evidense\n" +
                "exellent\n" +
                "excelent\n" +
                "excellant\n" +
                "exersize\n" +
                "exersise\n" +
                "exercize\n" +
                "exausted\n" +
                "exibit\n" +
                "existance\n" +
                "expensave\n" +
                "extrordinary\n" +
                "extraordinarey\n" +
                "extremley\n" +
                "extremeley\n" +
                "extremly\n" +
                "fasimilee\n" +
                "fasimile\n" +
                "fascimilee\n" +
                "fascimiley\n" +
                "familier\n" +
                "fasinate\n" +
                "fasen\n" +
                "february\n" +
                "Febuary\n" +
                "finaly\n" +
                "finnaly\n" +
                "finalley\n" +
                "foriegn\n" +
                "foriegner\n" +
                "foreigener\n" +
                "forfiet\n" +
                "forfet\n" +
                "formerley\n" +
                "fortunateley\n" +
                "fortey\n" +
                "ferther\n" +
                "gage \n" +
                "goverment\n" +
                "governmant\n" +
                "gramar\n" +
                "grammer\n" +
                "gratefull\n" +
                "gratful\n" +
                "garuntee\n" +
                "guarunte\n" +
                "harrassment\n" +
                "harassemenet\n" +
                "harrassement\n" +
                "hight\n" +
                "hieght\n" +
                "humourous\n" +
                "humerous\n" +
                "hurriedely\n" +
                "hurreidly\n" +
                "hurriedley\n" +
                "hysterecal\n" +
                "histyerical\n" +
                "identecal\n" +
                "illigal\n" +
                "ilegal\n" +
                "ilegible\n" +
                "illigible\n" +
                "illegable\n" +
                "ilustrate\n" +
                "illistrate\n" +
                "imagineary\n" +
                "imaginarey\n" +
                "imminant\n" +
                "immanent\n" +
                "impartal\n" +
                "incoherant\n" +
                "inconveneint\n" +
                "innconvenient\n" +
                "independant\n" +
                "indapendent\n" +
                "ineviteble\n" +
                "inevatable\n" +
                "inflamable\n" +
                "innflammable\n" +
                "inflammeble\n" +
                "influense\n" +
                "injureys\n" +
                "apliance\n" +
                "applience\n" +
                "inquirey\n" +
                "inteligence\n" +
                "intellegence\n" +
                "intrest\n" +
                "interfear\n" +
                "interpertation\n" +
                "interpratation\n" +
                "intterrupt\n" +
                "interupt\n" +
                "intoxecate\n" +
                "invollved\n" +
                "innvolved\n" +
                "eyerate\n" +
                "irayte\n" +
                "irrisistable\n" +
                "irresistable\n" +
                "itinerarey\n" +
                "itenirary\n" +
                "jealos\n" +
                "jelous\n" +
                "jewllrey\n" +
                "jewelery\n" +
                "jewellerey\n" +
                "knowlegable\n" +
                "legall\n" +
                "legetimite\n" +
                "legitemate\n" +
                "legitemite\n" +
                "lesure\n" +
                "liesure\n" +
                "langth\n" +
                "leneint\n" +
                "leethal\n" +
                "liabel\n" +
                "laible\n" +
                "likable\n" +
                "likley\n" +
                "livlihood\n" +
                "liveleehood\n" +
                "logecal\n" +
                "loveley\n" +
                "mandatary\n" +
                "maintanence\n" +
                "marraige\n" +
                "mariage\n" +
                "mathmatics\n" +
                "matress\n" +
                "matrress\n" +
                "matur\n" +
                "ment\n" +
                "medecine\n" +
                "merchendise\n" +
                "miniture\n" +
                "minemal\n" +
                "minemize\n" +
                "miscellaneos\n" +
                "miscelaneous\n" +
                "miscelleneous\n" +
                "certian\n" +
                "molesster\n" +
                "musle\n" +
                "mysterous\n" +
                "neccesary\n" +
                "negligance\n" +
                "niether\n" +
                "nuetral\n" +
                "neice\n" +
                "ninteen\n" +
                "nineth\n" +
                "noone\n" +
                "noticable\n" +
                "nucleer\n" +
                "obediant\n" +
                "ocurred\n" +
                "occured\n" +
                "occurence\n" +
                "ocurrence\n" +
                "occurance\n" +
                "ommission\n" +
                "ommision\n" +
                "ommited\n" +
                "ommitted\n" +
                "opinien\n" +
                "optomism\n" +
                "ordinarly\n" +
                "origenal\n" +
                "payed\n" +
                "paralell\n" +
                "parlament\n" +
                "particuler\n" +
                "pedestrien\n" +
                "penitrate\n" +
                "preform\n" +
                "permenent\n" +
                "permenently\n" +
                "permanentley\n" +
                "peservere\n" +
                "personel (the self)\n" +
                "personallity\n" +
                "personnell (workers)\n" +
                "persade\n" +
                "occassion\n" +
                "ocassion\n" +
                "desegnate\n" +
                "oportunity\n" +
                "opporrtunity\n" +
                "phony\n" +
                "physicley\n" +
                "phisically\n" +
                "plesant\n" +
                "posses\n" +
                "posess\n" +
                "possesion\n" +
                "possable\n" +
                "possably\n" +
                "possibley\n" +
                "potatoe\n" +
                "prefferred\n" +
                "prefered\n" +
                "prejidice\n" +
                "pressume\n" +
                "prevelent\n" +
                "primarey\n" +
                "probibly\n" +
                "proceedure\n" +
                "proffessor\n" +
                "professer\n" +
                "prominant\n" +
                "pronounciation\n" +
                "proove\n" +
                "privoke\n" +
                "psycology\n" +
                "persue\n" +
                "puting\n" +
                "qantity\n" +
                "questionaire\n" +
                "questionnarre\n" +
                "redily\n" +
                "realitey\n" +
                "receed\n" +
                "reciept\n" +
                "recognised\n" +
                "reccommend\n" +
                "reccomend\n" +
                "preceeding\n" +
                "privilage\n" +
                "privalege\n" +
                "reguler\n" +
                "relavent\n" +
                "releive\n" +
                "religous\n" +
                "resind\n" +
                "expence\n" +
                "repetetive\n" +
                "reqire\n" +
                "resistence\n" +
                "resturant\n" +
                "rythm\n" +
                "ridicoulus\n" +
                "rigourous\n" +
                "roomate\n" +
                "sabatage\n" +
                "sacrafice\n" +
                "saftey\n" +
                "satesfying\n" +
                "scedule\n" +
                "scissers\n" +
                "secratary\n" +
                "sieze\n" +
                "senoir\n" +
                "cense\n" +
                "seperate\n" +
                "sequince\n" +
                "seveer\n" +
                "severley\n" +
                "shineing\n" +
                "significent\n" +
                "similair\n" +
                "sincerley\n" +
                "solisit\n" +
                "somone\n" +
                "speces\n" +
                "speciman\n" +
                "speach\n" +
                "stoping\n" +
                "strate\n" +
                "strengthe\n" +
                "studeying\n" +
                "subesequent\n" +
                "sucess\n" +
                "succes\n" +
                "suffoccate\n" +
                "sufocate\n" +
                "sufficate\n" +
                "superintendant\n" +
                "innoccent\n" +
                "inocent\n" +
                "suplement\n" +
                "suppliment\n" +
                "supplament\n" +
                "suprise\n" +
                "suspence\n" +
                "tailight\n" +
                "tecnique\n" +
                "temprature\n" +
                "temperarily\n" +
                "therefor\n" +
                "theif\n" +
                "thouroughly\n" +
                "thogh\n" +
                "tradgedy\n" +
                "transfferred\n" +
                "transfered\n" +
                "transeint\n" +
                "travelled\n" +
                "tryed\n" +
                "trys\n" +
                "truely\n" +
                "twelveth\n" +
                "tyeing\n" +
                "unfortunatly\n" +
                "untill\n" +
                "unusal\n" +
                "useage\n" +
                "usefull\n" +
                "use-less\n" +
                "useing\n" +
                "utalize\n" +
                "utilise\n" +
                "valuble\n" +
                "valueble\n" +
                "varietey\n" +
                "vegatable\n" +
                "vegetabel\n" +
                "vehicel\n" +
                "villian\n" +
                "vilain\n" +
                "warant\n" +
                "warrent\n" +
                "wether\n" +
                "weather (either or)\n" +
                "writeing\n" +
                "writtin\n" +
                "your (you are)\n" +
                "youre\n";
    }
}
