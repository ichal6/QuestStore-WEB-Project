package service;

import DAO.*;
import exception.NoComparatorException;
import exception.ReadException;
import model.Codecooler;
import org.postgresql.ds.PGSimpleDataSource;
import sort.*;

import java.io.IOException;
import java.util.*;

public class CodecoolerService {
    private final CodecoolerDAO codecoolerDAO;
    private final CodecoolerClassDAO classDAO;
    private final TeamDAO teamDAO;

    public CodecoolerService(CodecoolerDAO codecoolerDAO, CodecoolerClassDAO classDAO, TeamDAO teamDAO) {
        this.codecoolerDAO = codecoolerDAO;
        this.classDAO = classDAO;
        this.teamDAO = teamDAO;
    }

    public Map<Codecooler, List<String>> getAllCodecoolersWithClassNameAndTeamName(String sortBy, Boolean order) throws ReadException, IOException {
        List<Codecooler> allCodecoolers = codecoolerDAO.getAllCodecoolers();
        if (order != null && sortBy != null) {
            try {
                allCodecoolers = sortList(allCodecoolers, order, sortBy);
            } catch (NoComparatorException e) {
                throw new ReadException(e.getMessage());
            }
        }
        return addDetailsToCodecoolersList(allCodecoolers);
    }

    private List<Codecooler> sortList(List<Codecooler> allCodecoolers, boolean order, String sortBy) throws NoComparatorException, IOException {
        PGSimpleDataSource ds = DataSourceReader.getDataSource("src/main/resources/database.properties");
        Comparing<Codecooler> comparing = new ComparatorCodecooler(new TeamJDBCDAO(), new CodecoolerClassJDBCDAO(ds));
        TypeColumn typeColumn = TypeColumn.returnType(sortBy);
        Comparator<Codecooler> comparator = comparing.getComparator(typeColumn);
        SortItems<Codecooler> sortItems = new SortItems<>(allCodecoolers, comparator);

        return sortItems.sort(order);
    }

    private Map<Codecooler, List<String>> addDetailsToCodecoolersList(List<Codecooler> allCodecoolers) throws ReadException {
        Map<Codecooler, List<String>> codecoolersWithDetails = new LinkedHashMap<>();

        for (int i = 0; i < allCodecoolers.size(); i++) {
            Codecooler codecooler = allCodecoolers.get(i);
            String className = "";
            String teamName = "";
            if (codecooler.getClassId() != null && codecooler.getClassId() != 0) {
                className = classDAO.getCodecoolerClassById(codecooler.getClassId()).getName();
            }
            if (codecooler.getTeamId() != null && codecooler.getTeamId() != 0) {
                teamName = teamDAO.getTeamById(codecooler.getTeamId()).getName();
            }
            List<String> details = List.of(className, teamName);
            codecoolersWithDetails.put(codecooler, details);
        }
        return codecoolersWithDetails;
    }
}
