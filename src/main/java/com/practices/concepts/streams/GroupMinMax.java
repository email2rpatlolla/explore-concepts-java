package com.practices.concepts.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.practices.pojo.Player;

public class GroupMinMax {

	public static void main(String[] args) {
		
		Player player1 = new Player("Messey", 10 , 1, 12.5f);
		Player player2 = new Player("Mbhape", 11 , 5, 14.5f);
		Player player3 = new Player("Ronaldo", 9 , 3, 12.5f);
		
		var list = new ArrayList<Player>() {
			private static final long serialVersionUID = 1L;
			{
                add(player1);
                add(player2);
                add(player3);
            }
        };
        
		var result1 = list.stream().collect(Collectors.maxBy(Comparator.comparing(Player::getRank)));


		var result2 = list.stream().collect(Collectors.minBy(Comparator.comparing(Player::getRank)));
		var result3 = list.stream().collect(
					Collectors.teeing(
							Collectors.maxBy(Comparator.comparing(Player::getRank)), 
							Collectors.minBy(Comparator.comparing(Player::getRank)), (m1, m2) -> Arrays.asList(m1, m2)));
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);

	}

}
