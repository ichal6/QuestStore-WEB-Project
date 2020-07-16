package service;

import DAO.*;
import exception.NoComparatorException;
import exception.ReadException;
import model.Codecooler;
import org.postgresql.ds.PGSimpleDataSource;
import sort.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodecoolerService {
    private final CodecoolerDAO codecoolerDAO;
    private final CodecoolerClassDAO classDAO;
    private final TeamDAO teamDAO;

    public CodecoolerService(CodecoolerDAO codecoolerDAO, CodecoolerClassDAO classDAO, TeamDAO teamDAO) {
        this.codecoolerDAO = codecoolerDAO;
        this.classDAO = classDAO;
        this.teamDAO = teamDAO;
    }

    public Map<Codecooler, Map<String, String>> getAllCodecoolersWithClassNameAndTeamName(String sortBy, Boolean order) throws ReadException, IOException {
        List<Codecooler> allCodecoolers = codecoolerDAO.getAllCodecoolers();
        if (order != null && sortBy != null) {
            try {
                allCodecoolers = sortList(allCodecoolers, order, sortBy);
            } catch (NoComparatorException e) {
                throw new ReadException(e.getMessage());
            }
        }
        Map<Codecooler, Map<String, String>> codecoolersWithClassNamesAndTeamNames = addDetailsToCodecoolersList(allCodecoolers);
        return codecoolersWithClassNamesAndTeamNames;
    }

    private List<Codecooler> sortList(List<Codecooler> allCodecoolers, boolean order, String sortBy) throws NoComparatorException, IOException {
        PGSimpleDataSource ds = DataSourceReader.getDataSource("src/main/resources/database.properties");
        Comparing<Codecooler> comparing = new ComparatorCodecooler(new TeamJDBCDAO(), new CodecoolerClassJDBCDAO(ds));
        TypeColumn typeColumn = TypeColumn.returnType(sortBy);
        Comparator<Codecooler> comparator = comparing.getComparator(typeColumn);
        SortItems<Codecooler> sortItems = new SortItems<>(allCodecoolers, comparator);

        return sortItems.sort(order);
    }

    private Map<Codecooler, Map<String, String>> addDetailsToCodecoolersList(List<Codecooler> allCodecoolers) {
        Map<Codecooler, Map<String, String>> codecoolersWithDetails = new HashMap<>();

        for (int i = 0; i < allCodecoolers.size(); i++) {
            Codecooler codecooler = allCodecoolers.get(i);
            String className = classDAO.getCodecoolerClassById(codecooler.getClassId())

                    // null?
        }

        return codecoolersWithDetails;
    }
}
