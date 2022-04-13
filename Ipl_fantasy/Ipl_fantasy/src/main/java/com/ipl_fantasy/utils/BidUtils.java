package com.ipl_fantasy.utils;

import com.ipl_fantasy.dto.BidDTO;
import com.ipl_fantasy.entities.BidEntity;

//import java.util.ArrayList;
//import java.util.List;




public class BidUtils {

//	public static List<MatchScheduleDTO> convertToMatchScheduleDtoList(List<MatchScheduleEntity> list){
//		List<MatchScheduleDTO> dtolist = new ArrayList<MatchScheduleDTO>();
//		for(MatchScheduleEntity matchentity:list) {
//			dtolist.add(convertToMatchScheduleDto(matchentity));
//		}
//		return dtolist;
//	}
	
	public static BidEntity convertToBidEntity(BidDTO biddto) {
		BidEntity bident = new BidEntity();
		bident.setUser_id(biddto.getUser_id());
		bident.setUser_opinion1(biddto.getUser_opinion1());
		bident.setUser_opinion2(biddto.getUser_opinion2());		
		bident.setMatch_id(biddto.getMatch_id());
		return bident;
	}
}
