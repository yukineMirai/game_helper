package com.dkm.game.article.controller;

import com.dkm.basic.component.ext.web.BaseController;
import com.dkm.basic.component.ext.web.BaseResp;
import com.dkm.basic.component.ext.web.PageResp;
import com.dkm.game.article.entity.GameArticleEntity;
import com.dkm.game.article.params.GameArticleParams;
import com.dkm.game.article.req.GameArticleReq;
import com.dkm.game.article.service.GameArticleService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping(value = "/game/article/manage/", produces = "application/json;charset=utf-8")
@RestController
public class GameArticleController extends BaseController {

    @Autowired
    GameArticleService gameArticleService;

    @RequestMapping(value = "query", method = RequestMethod.POST)
    public ResponseEntity<PageResp<GameArticleReq>> query(HttpServletRequest request,
                                                             @And({@Spec(params = "gid", path = "gid", spec = Equal.class),
                                                                     @Spec(params = "title", path = "title", spec = Like.class),
                                                                     @Spec(params = "isShow", path = "isShow", spec = Equal.class),
                                                                     @Spec(params = "content", path = "content", spec = Like.class)})
                                                                     Specification<GameArticleEntity> spec,
                                                             @RequestParam int page,
                                                             @RequestParam int rows){


        Pageable pageable = new PageRequest(page - 1, rows, new Sort(new Sort.Order(Sort.Direction.DESC, "createTime")));
        PageResp<GameArticleReq> rep = this.gameArticleService.gameArticleQuery(spec, pageable);

        return new ResponseEntity<PageResp<GameArticleReq>>(rep, HttpStatus.OK);
    }



    @RequestMapping(value = "add")
    public ResponseEntity<BaseResp> add(@Valid GameArticleParams params){


        String operator = super.getLoginUser();
        BaseResp resp = gameArticleService.add(params,operator);

        return new ResponseEntity<BaseResp>(resp,HttpStatus.OK);
    }


    @RequestMapping(value = "update")
    public ResponseEntity<BaseResp> update(@Valid GameArticleParams params){

        String operator = super.getLoginUser();
        BaseResp resp = gameArticleService.add(params,operator);

        return new ResponseEntity<BaseResp>(resp,HttpStatus.OK);
    }


    @RequestMapping(value = "delete")
    public ResponseEntity<BaseResp> delete(@RequestParam String id){

        String operator = super.getLoginUser();
        BaseResp resp = gameArticleService.detele(id,operator);

        return new ResponseEntity<BaseResp>(resp,HttpStatus.OK);
    }
}