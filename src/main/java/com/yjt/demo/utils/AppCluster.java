package com.yjt.demo.utils;

import com.yjt.demo.domain.appinfoma;

import java.util.List;

public class AppCluster extends KMeansClustering<appinfoma> {

    @Override
    public double similarScore(appinfoma o1, appinfoma o2) {
        double distance=Math.sqrt((o1.getTools()-o2.getTools())*(o1.getTools()-o2.getTools())+(o1.getGame()-o2.getGame())*(o1.getGame()-o2.getGame())+(o1.getMoney()-o2.getMoney())*(o1.getMoney()-o2.getMoney())+(o1.getMovie()-o2.getMovie())*(o1.getMovie()-o2.getMovie())+(o1.getMusic()-o2.getMusic())*(o1.getMusic()-o2.getMusic())+(o1.getOffice()-o2.getOffice())*(o1.getOffice()-o2.getOffice())+(o1.getSocial()-o2.getSocial())*(o1.getSocial()-o2.getSocial()));
        return distance*-1;
    }

    @Override
    public boolean equals(appinfoma o1, appinfoma o2) {

         
        return o1.getSocial()==o2.getSocial()&&o1.getOffice()==o2.getOffice()&&o1.getMusic()==o2.getMusic()
                &&o1.getMovie()==o2.getMovie()&&o1.getMoney()==o2.getMoney()&&o1.getGame()==o2.getGame()&&o1.getTools()==o2.getTools();
    }

    @Override
    public appinfoma getCenterT(List<appinfoma> list) {

        int music=0;
        int social=0;
        int movie=0;
        int game=0;
        int money=0;
        int office=0;
        int tools=0;
        try {
            for (appinfoma a : list)
            {
                music+=a.getMusic();
                social+=a.getSocial();
                movie+=a.getMovie();
                game+=a.getGame();
                money+=a.getMoney();
                office+=a.getOffice();
                tools+=a.getTools();
            }
            music=music/list.size();
            social=social/list.size();
            movie=movie/list.size();
            game=game/list.size();
            money=money/list.size();
            office=office/list.size();
            tools=tools/list.size();
        }
        catch (Exception e){

        }
        return new appinfoma(game,office,tools,music,social,movie,money);
    }
}
