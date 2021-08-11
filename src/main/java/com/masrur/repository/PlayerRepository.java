package com.masrur.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.masrur.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Player save(Player ply) {
        dynamoDBMapper.save(ply);
        return ply;
    }

    public Player getPlayerById(String playerId) {
        return dynamoDBMapper.load(Player.class, playerId);
    }

    public String delete(String playerId) {
    	Player ply = dynamoDBMapper.load(Player.class, playerId);
        dynamoDBMapper.delete(ply);
        return "Employee Deleted!";
    }

    public String update(String playerId, Player ply) {
        dynamoDBMapper.save(ply,
                new DynamoDBSaveExpression()
        .withExpectedEntry("playerId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(playerId)
                )));
        return playerId;
    }
}
