package com.yjt.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class appinfoma {
    @Id
    String userid;
    int game;
    int office;
    int tools;
    int music;
    int social;
    int movie;
    int money;

    public appinfoma() {
    }

    public appinfoma(int game, int office, int tools, int music, int social, int movie, int money) {
        this.game = game;
        this.office = office;
        this.tools = tools;
        this.music = music;
        this.social = social;
        this.movie = movie;
        this.money = money;
    }

    @Override
    public String toString() {
        return  game +
                "," + office +
                "," + music +
                "," + social +
                "," + movie +
                "," + money +
                ","+tools;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, office, tools, music, social, movie, money);
    }

    public int getGame() {
        return game;
    }

    public int getOffice() {
        return office;
    }

    public int getMusic() {
        return music;
    }

    public int getSocial() {
        return social;
    }

    public int getMovie() {
        return movie;
    }

    public int getMoney() {
        return money;
    }

    public int getTools() {
        return tools;
    }

    public void setTools(int tools) {
        this.tools = tools;
    }
}
