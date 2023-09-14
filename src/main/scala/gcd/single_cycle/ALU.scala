package single_cycle

import chisel3._
import chisel3.util._
object aluop{
  val aluADD = 0.U(4.W)
  val aluSUB = 1.U(4.W)
  val aluSLL = 2.U(4.W)
  val aluSLT = 4.U(4.W)
  val aluSLTU = 6.U(4.W) 
  val aluXOR = 8.U(4.W)
  val aluSRL = 10.U(4.W)
  val aluSRA = 11.U(4.W)
  val aluOR = 12.U(4.W)
  val aluAND = 14.U(4.W)
}
// object Branch{
//   val aluBeq = 0.U(4.W)
//    val aluBne = 1.U(4.W)
//    val aluBlt = 4.U(4.W)
//    val aluBge = 5.U(4.W)
//    val aluBltu = 6.U(4.W)
//    val aluBgeu = 7.U(4.W)
  
// }
// class LM_IO_Interface_BranchControl extends Bundle {
// val fnct3 = Input ( UInt (3. W ) )
// val branch = Input ( Bool () )
// val arg_x = Input ( UInt (32. W ) )
// val arg_y = Input ( UInt (32. W ) )
// val br_taken = Output ( Bool () )
// }
// class BranchControl extends Module {
// val io = IO (new LM_IO_Interface_BranchControl )
// io.br_taken := 0.B
// when(io.branch===1.B){
// switch(io.fnct3)
// {
//     is(0.U){
//         when(io.arg_x===io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is(1.U){
//         when(io.arg_x=/=io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is(4.U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is(5.U){
//         when(io.arg_x >= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is(6.U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is(7.U){
//         when(io.arg_x>= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }}
// }
//     .otherwise{
//         io.br_taken:=0.B
//     }

// }

class ALUD extends Module {
  val io = IO(new Bundle {
    val in_A = Input(UInt(32.W))
    val in_B = Input(UInt(32.W))
    val aluop = Input (UInt(4.W))
    val out = Output(UInt(32.W))
  
  })

  io.out := 0.U

  // Handle different ALU operations based on fun3 and fun7
  switch(io.aluop) {
    is(0.U) {
      io.out := io.in_A + io.in_B
    }
    is(1.U) { // SLL
          io.out := io.in_A - io.in_B
    }
    is(2.U){

      io.out := io.in_A << (io.in_B(4, 0).asUInt)
    }
    is(4.U) { // SLT
      io.out := (io.in_A.asSInt < io.in_B.asSInt).asUInt
    }
    is(6.U) { // SLTU
      io.out := (io.in_A < io.in_B).asUInt
    }
    is(8.U) { // XOR
      io.out := io.in_A ^ io.in_B
    }
    is(10.U) { // SRL
        io.out := io.in_A >> (io.in_B(4, 0).asUInt)
     
    }
     is(11.U) { // SRA
        io.out := (io.in_A.asSInt >> (io.in_B(4, 0).asUInt)).asUInt
      }
    is(12.U) { // OR
      io.out := io.in_A | io.in_B
    }
    is(14.U) { // AND
      io.out := io.in_A & io.in_B
    }
  }
}
