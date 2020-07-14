package service;

import DAO.QuestDAO;
import exception.ReadException;
import model.Quest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;

class QuestServiceTest {

    @InjectMocks
    QuestService questService;

    @Mock
    QuestDAO questDAO;

    @BeforeEach
    public void init() throws ReadException {
        MockitoAnnotations.initMocks(this);
        given(questDAO.getAllQuests()).willReturn(prepareMockData());
    }

    @Test
    public void shouldGetUnsortedQuestsIfSortingParametersDontExist() throws ReadException {
        // given:
        String sortBy = null;
        Boolean order = null;
        List<Quest> questListBeforeSort = prepareMockData();

        // when:
        List<Quest> questListFromService = questService.getAllQuests(sortBy, order);

        // then:
        Assertions.assertEquals(questListBeforeSort.get(0).getID(), questListFromService.get(0).getID());
        Assertions.assertEquals(questListBeforeSort.get(1).getID(), questListFromService.get(1).getID());
        Assertions.assertEquals(questListBeforeSort.get(2).getID(), questListFromService.get(2).getID());
    }

    private List<Quest> prepareMockData() {
        Quest quest1 = new Quest();
        quest1.setID(11);
        Quest quest2 = new Quest();
        quest2.setID(8);
        Quest quest3 = new Quest();
        quest3.setID(22);
        List<Quest> questList = new ArrayList<>();
        questList.add(quest1);
        questList.add(quest2);
        questList.add(quest3);

        return questList;
    }
}