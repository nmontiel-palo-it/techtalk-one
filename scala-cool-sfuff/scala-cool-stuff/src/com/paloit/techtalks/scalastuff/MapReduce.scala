package com.paloit.techtalks.scalastuff

object MapReduce {
  
  
  def main(args: Array[String]){
    
    val numeros : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    
    val resultado = numeros
    .filter(_ < 20)
    .sorted
    .map( s => s *10 )
    .toList
   
    printf("[%s]",  resultado)
    
  }
  
  
  
}