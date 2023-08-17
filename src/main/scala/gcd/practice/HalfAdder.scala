// package  practice
// import chisel3._
// import chisel3.util._

// class HalfAdder extends  Module{
//     val io = IO(new Bundle{
//         val in1 = Input(UInt(3.W))
//         val in2 = Input(UInt(3.W))
//         val out = Output(UInt(3.W))
//         val cout = Output(UInt(3.W))
//     })
//     io.out := io.in1 ^ io.in2
//     io.cout := io.in1 & io.in2
// }