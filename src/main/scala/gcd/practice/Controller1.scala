// package practice
// import chisel3 . _
// import chisel3.util._

// class Controller extends  Module{
//    val io = IO(new Bundle{
//     //Input
// val zero = Input (Bool ())
// val phase = Input (UInt(3.W))
// val opcode = Input (UInt(3.W))

// //output
// val zero = Input (Bool ())
// val rd = Output(Bool ())
// val id_ir = Output(Bool ())
// val inc_pc = Output(Bool ())
// val halt = Output(Bool ())
// val id_pc = Output(Bool ())
// val data_c = Output(Bool ())
// val id_ac = Output(Bool ())
// val wr = Output(Bool ())
//   })
//   io.sel := 0.B
//     io.rd := 0.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B

// when(io.phase === 0.U & io.opcode === 0.U){
//     io.sel := 1.B
//     io.rd := 0.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 1.U & io.opcode === 1.U){
//     io.sel := 1.B
//     io.rd := 1.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 2.U & io.opcode === 2.U){
//     io.sel := 1.B
//     io.rd := 1.B
//     io.id_ir := 1.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 3.U & io.opcode === 3.U){
//     io.sel := 1.B
//     io.rd := 1.B
//     io.id_ir := 1.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 4.U & io.opcode === 4.U){
//     io.sel := -0.B
//     io.rd := 0.B
//     io.id_ir := 0.B
//     io.inc_pc := 1.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 5.U & io.opcode === 5.U){
//     io.sel := 0.B
//     io.rd := 1.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 6.U & io.opcode === 6.U){
//     io.sel := 0.B
//     io.rd := 0.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 0.B
//     io.data_c := 1.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// }
// .elsewhen(io.phase === 7.U & io.opcode === 7.U){
//     io.sel := 0.B
//     io.rd := 0.B
//     io.id_ir := 0.B
//     io.inc_pc := 0.B
//     io.halt := 0.B
//     io.id_pc := 1.B
//     io.data_c := 0.B
//     io.id_ac:= 0.B
//     io.wr := 0.B
// } 
//          }
