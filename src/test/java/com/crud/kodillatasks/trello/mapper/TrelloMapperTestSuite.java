package com.crud.kodillatasks.trello.mapper;

import com.crud.kodillatasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testCard", "for test usage", "1", "1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertNotNull(trelloCardDto);
        Assert.assertEquals("testCard", trelloCardDto.getName());
        Assert.assertEquals("for test usage", trelloCardDto.getDescription());
        Assert.assertEquals("1", trelloCardDto.getPos());
        Assert.assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testCard", "for test usage", "1", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertNotNull(trelloCard);
        Assert.assertEquals("testCard", trelloCard.getName());
        Assert.assertEquals("for test usage", trelloCardDto.getDescription());
        Assert.assertEquals("1", trelloCardDto.getPos());
        Assert.assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "testList", true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(trelloList);
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(lists);
        //Then
        Assert.assertNotNull(trelloListDto);
        Assert.assertEquals(1, trelloListDto.size());
        Assert.assertEquals("1", trelloListDto.get(0).getId());
        Assert.assertEquals("testList", trelloListDto.get(0).getName());
        Assert.assertTrue(trelloListDto.get(0).isClosed());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "testList", true);
        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(trelloListDto);
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(lists);
        //Then
        Assert.assertNotNull(trelloList);
        Assert.assertEquals(1, trelloList.size());
        Assert.assertEquals("1", trelloList.get(0).getId());
        Assert.assertEquals("testList", trelloList.get(0).getName());
        Assert.assertTrue(trelloList.get(0).isClosed());
    }
    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> testLists = new ArrayList<>();
        TrelloBoard board1 = new TrelloBoard("1", "testBoard", testLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(board1);
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        Assert.assertNotNull(trelloBoardsDto);
        Assert.assertEquals(1, trelloBoardsDto.size());
        Assert.assertEquals("1", trelloBoardsDto.get(0).getId());
        Assert.assertEquals("testBoard", trelloBoardsDto.get(0).getName());
    }

    @Test
    public void testMapToBoards() {
        //Given
        TrelloBoardDto board1 = new TrelloBoardDto("1", "testBoard", new ArrayList<TrelloListDto>());
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(board1);
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        Assert.assertNotNull(trelloBoards);
        Assert.assertEquals(1, trelloBoards.size());
        Assert.assertEquals("1", trelloBoards.get(0).getId());
        Assert.assertEquals("testBoard", trelloBoards.get(0).getName());
    }
}
