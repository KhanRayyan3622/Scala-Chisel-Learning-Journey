// package practice
// import chisel3._


// class Countermsb ( size :Int ) extends Module {
// val io = IO (new Bundle {
//     val result = Output ( Bool () )
// })
//  val count = RegInit (0.U (16.W))
//  val max = (1.U << size) - (1.U << (size-1))

//  when (count === max) {
//     count := 0.U

//  }
//  .otherwise{
//     count := count + 1. U
//  }
//  io.result:=count(size-1)
// }
//  //println ( s" counter created with max value $max ") 

