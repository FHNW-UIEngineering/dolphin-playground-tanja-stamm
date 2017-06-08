package myapp.service.impl;

import java.util.List;
import java.util.Random;

import org.opendolphin.core.server.DTO;

import myapp.presentationmodel.canton.CantonAtt;
import myapp.service.SomeService;
import myapp.util.DTOMixin;

public class SomeRemoteService implements SomeService, DTOMixin {

    //private static final String FILE_NAME = "/data/eeg_anlagen_kurz.csv";
    //private static final String DELIMITER = ";";

    String[] names = {"Bern"  , "Zürich" , "Aargau",      // Apollo 11
                      "Jura" , "Genf"  , "Zug",         // Apollo 12
                      "Luzern"   , "Uri"    , "Schwyz"}; // Apollo 17

    @Override
    public DTO loadSomeEntity() {
        long id = createNewId();

        Random r        = new Random();
        String name     = names[r.nextInt(names.length)];
        int    age      = r.nextInt(43);
        String mainTown = "ich bin mainTown";
        int citizens = 89;
        int area = 12;
        String language = "german";
        //boolean isAdult = age >= 18;
        return new DTO(createSlot(CantonAtt.ID, id     , id),
                       createSlot(CantonAtt.NAME, name   , id),
                       createSlot(CantonAtt.MAINTOWN, mainTown    , id),
                       createSlot(CantonAtt.CITIZENS, citizens    , id),
                       createSlot(CantonAtt.AREA, area    , id),
                       createSlot(CantonAtt.LANGUAGE, language    , id));
    }

    @Override
    public void save(List<DTO> dtos) {
        System.out.println(" Data to be saved");
        dtos.stream()
            .flatMap(dto -> dto.getSlots().stream())
            .map(slot -> String.join(", ", slot.getPropertyName(), slot.getValue().toString(), slot.getQualifier()))
            .forEach(System.out::println);
    }
}
