// package Lab_1

// import chisel3._
// import chisel3.util._
// import scala.language.postfixOps

// class counterMSB(counterBits: Int) extends Module {
//   val io = IO(new Bundle {
//     val result = Output(Bool())
//   })
//   //val counterBits = Wire(SInt())
//   var max = ((1.U << counterBits))

//   var count = RegInit(0.U(4.W))

//   when(max === count) {
//     count := 0.U
//   }.otherwise {
//     count := count + 1.U

//   }

//   io.result := count(3.U)
//   println(s" counter created with max value $max ")

// }

// // class Counter2( counterBits : UInt) extends Module {

// //         val io = IO(new Bundle {
// //             val result = Output ( Bool() )
// //         })
// //         val max = (1.U << counterBits) - (1.U << (counterBits - 1.U))
// //         val count = RegInit (0.S (16.W))

// //         when( count === max.asSInt ){
// //             count := 0.S
// //         }.otherwise {
// //             count := count + 1.S
// //         }
// //         io.result := count
// //         println(s" Counter created with max value $max ")
// // }