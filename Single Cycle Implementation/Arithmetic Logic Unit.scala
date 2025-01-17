package single_cycle

import chisel3._
import chisel3.util._

object aluop{
  val ADD = 0.U(4.W)
  val SUB = 1.U(4.W)
  val AND = 2.U(4.W)
  val OR = 4.U(4.W)
  val GTE = 5.U(4.W)
  val XOR = 6.U(4.W)
  val LTE = 7.U(4.W)
  val SLL = 8.U(4.W)
  val SLT = 10.U(4.W)
  val SLTU = 11.U(4.W) 
  val SRL = 12.U(4.W)
  val SRA = 14.U(4.W)
}

class ALU_imp extends Module {
  val io = IO(new Bundle {
    val in_A = Input(UInt(32.W))
    val in_B = Input(UInt(32.W))
    val aluop = Input (UInt(4.W))
    val out = Output(UInt(32.W))
  
  })

  io.out := 0.U

  switch(io.aluop) {
// NOW, IMPLEMENTATIONS OF THE OPERATIONS
    // ADDITION
    is(0.U) { 
      io.out := io.in_A + io.in_B
    }
    // SUBTRACT
    is(1.U) { 
      io.out := io.in_B - io.in_A
    }
    // AND
    is(2.U) {
      io.out := io.in_A & io.in_B
    }
    // OR
    is(4.U) { 
      io.out := io.in_A | io.in_B
    }
    // GREATER THEN EQUAL TO
    is(5.U) { 
      io.out := (io.in_A.asSInt >= io.in_B.asSInt).asUInt

    // XOR
    is(6.U) { 
      io.out := io.in_A ^ io.in_B
    }
    
    // LESS THEN EQUAL TO
    is(7.U) { 
      io.out := (io.in_A.asSInt <= io.in_B.asSInt).asUInt
    }

    // SHIFT LEFT LOGICAL
    is(8.U) { 
      io.out := io.in_A << (io.in_B(4, 0).asUInt)
    }
    // SET LESS THAN
    is(10.U) { 
      io.out := (io.in_A.asSInt < io.in_B.asSInt).asUInt
    }
    // SLTU
    is(11.U) {
      io.out := (io.in_A < io.in_B).asUInt
    }
    // SRL
    is(12.U) { 
        io.out := io.in_A >> (io.in_B(4, 0).asUInt)     
    }
    // SRA
     is(14.U) { 
        io.out := (io.in_A.asSInt >> (io.in_B(4, 0).asUInt)).asUInt
      }

  }
}}
