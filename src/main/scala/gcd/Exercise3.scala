// // package Lab_1
// // import chisel3._
// // import chisel3.util._
// // import scala.language.postfixOps

// // class chisel_1 extends Module {
// //     val io = IO(new Bundle {
// //         val in1 = Input(UInt(3.W))
// //         val in2 = Input(UInt(3.W))
// //         val out = Output(UInt(3.W))
// //     })
// //     io.out := io.in1 & io.in2
// // }

// // class Counter (size : Int , maxValue : UInt) extends Module {
// //     val io = IO (new Bundle {
// //         // class max;int
// //         // val result = Output (Bool())
// //         // count UInt
// //         // val abc=WireInit(max.U)

// //     })

// //     def genCounter ( n : Int , max : UInt ) = {
// //         val count = RegInit (0. U ( n . W ) )
// //      when ( count === abc) {
// //             count := 0. U
// //         } .otherwise {
// //             count := count + 1. U
// //         }
// //         count
// //     }
// // // genCounter instantiation
// //     val counter1 = genCounter ( size , maxValue )
// //     io . result := counter1 ( size -1)

// // println((new chisel3.stage.ChiselStage).emitVerilog(new Counter(8, 255.U)))
// // }

// package Lab_1

// import chisel3._
// import chisel3.util._
// import scala.language.postfixOps

// class Typecast( size : Int , maxValue : UInt ) extends Module {  // U
//     val io = IO (new Bundle {
//         val result = Output ( Bool())
//     })
//     io.result := 0.B
//     // 'genCounter ' with counter size 'n'
//     def genCounter ( n : Int , max : UInt) = {         
//         val count = RegInit(0.U(n.W))
//         // Int max2 
//         // max2 := max
//         // max2 := max2.asInstanceOf[Data]
//         // count := count.asInstanceOf[Data]
//         when( count === max.asUInt ){                        
//             count := 0.U
//             io.result := 1.B   
//         }.otherwise{
//             count := count + 1.U
//         }
//         count
//     }
//     // genCounter instantiation
//     //val counter1 = 
//     genCounter( size , maxValue )
//     /// counter =counter -1 
//     //io.result := counter1(size-1)
// }

// // object Main extends App{
    
// //     // val exe_count = Module(new Counter(3.U))
// //     // println(new chisel3.stage.ChiselStage)
// //     // println((new chisel3.stage.ChiselStage).emitVerilog(new Counter(1.U)))
// //     println(( new chisel3.stage.ChiselStage ).emitVerilog(new Counter(8 , 255)))
// // }