// package Lab_1

// import chisel3._
// import chisel3.util._
// import scala.language.postfixOps

// // class chisel_2 extends Module {
// //     val io = IO(new Bundle {
// //         val in1 = Input(UInt(3.W))
// //         val in2 = Input(UInt(3.W))
// //         val out = Output(UInt(3.W))
// //     })
// //     io.out := io.in1 & io.in2

// // class Counter (counterBits : SInt) extends Module {
// //     val io = IO (new Bundle {
// //         val result = Output (Bool ())
// //     })
// //     val abc = counterBits.asUInt
// //     val max = (1.U << abc ) - 1.U
// //     val count = RegInit (0.U(16.W))
// //     when ( count === max ) {
// //         count := 0.U
// //     }.otherwise {
// //         count := count + 1.U
// //     }
// //     io . result := count (15.U)
// //     println ( s" counter created with max value $max ")
// // }

// class Counter( counterBits : UInt) extends Module {

//         val io = IO(new Bundle {
//             val result = Output ( Bool() )
//         })
//         val max = (1.U << counterBits) - 1.U
//         val count = RegInit (0.S (16.W))

//         when( count === max.asSInt ){
//             count := 0.S
//         }.otherwise {
//             count := count + 1.S
//         }
//         io.result := count
//         println(s" Counter created with max value $max ")
// }
