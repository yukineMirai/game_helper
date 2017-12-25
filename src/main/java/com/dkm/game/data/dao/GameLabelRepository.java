package com.dkm.game.data.dao;

import com.dkm.game.data.entity.GameLabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GameLabelRepository extends JpaRepository<GameLabelEntity, String> ,JpaSpecificationExecutor<GameLabelEntity> {


    public GameLabelEntity findByGidAndLid(String gid,String lid);


    public List<GameLabelEntity> findByGid(String gid);


    /*@Query("select gl.lid from  game_label gl where gl.gid = :gid")*/
  /*  public String getLid2(@Param("gid") String gid);*/
/*
    @Query("select gl.lid from  game_label gl where gl.gid = ?1")
    public String getLid( String gid);*/

    /*@Query("select gl.lid from  game_label gl where gl.gid = :gid")
    public String getLid2(@Param("gid") String gid);

    @Query("select gl.lid from  GameLabelEntity gl where gl.gid = :gid")
    public String getLid3(@Param("gid") String gid);*/

    /*@Query("select gl.lid from  #{#emtityName} gl where gl.gid = :gid")
    public String getLid4(@Param("gid") String gid);*/
}
