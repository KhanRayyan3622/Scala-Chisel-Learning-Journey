package single_cycle

import chisel3._
import chisel3.util._

class controlunit extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(32.W))
    val op_code = Output(UInt(7.W))
    val aluop = Output(UInt(4.W))
    val rd = Output(UInt(5.W))
    val rs1 = Output(UInt(5.W))
    val rs2 = Output(UInt(5.W))
    val format =Output(Bool()) 
    val s_form = Output(Bool())
    val b_form = Output(Bool())
    val imm = Output(UInt(32.W)) 
    val mem_wr_en = Output (Bool())
    val wr_en = Output(Bool())
    val wr_back = Output (Bool())
    val func3 = Output(UInt(3.W))
    val func7 = Output(UInt(7.W))

  })
        io.op_code := (io.in(6,0))
        io.format:=0.B
        io.rs1 := 0.U
        io.rs2 := 0.U
        io.rd := 0.U
        io.imm := 0.U
        io.aluop:= 0.U
        io.s_form:=0.B
        val f3 = io.in(14,12)
        val f7 = io.in(31,25)
            

    when (io.op_code === "b0110011".U ){//rtype
        io.format :=1.B
        io.wr_en := 1.B
        io.wr_back :=1.B
        io. rd :=(io.in(11,7))
        io. aluop :=Cat(f3,f7(5))
        io. rs1 :=(io.in(19,15))
        io. rs2  :=(io.in(24,20))
    }
    .elsewhen(io.op_code === "b0010011".U){//itype
        io.format := 0.B
        io.wr_en :=1.B
        io.wr_back :=1.B
        io. rd :=(io.in(11,7))
        io. aluop :=Cat(f3,0.U)
        when(f3===5.U||f3===1.U){
            io. aluop :=Cat(f3,f7(5))
        }
        .otherwise{
            io. aluop :=Cat(f3,0.U)
        }
        io. rs1 :=(io.in(19,15))
        //io.imm := io.in(31,20)
            io.imm := Cat(Fill(19,io.in(31)),io.in(31,20))

    }
    .elsewhen(io.op_code === "b0000011".U){//LOAD

     io.wr_en:=1.B
     io.format:=0.B
     io.rd:=(io.in(11,7))
     io.rs1:=(io.in(20,15))
     io.aluop:=0.B
     io.mem_wr_en:=0.B
     io.wr_back:=0.B
     io.rs2:=0.B

     io.imm := Cat(Fill(19,io.in(31)),io.in(31,20))
}

   .elsewhen(io.op_code === "b0100011".U){//store
    io.wr_en:=0.B

    io.s_form:=1.B
    io.rs1:=(io.in(20,15))
     io.rs2:=(io.in(25,21))
     //when(f3)
       io.imm := Cat(Fill(19,io.in(31)),io.in(31,25),io.in(11,7))
      io.aluop:= 0.U
      io.mem_wr_en:=1.B
      io.wr_back:=0.B
}

.elsewhen(io.op_code === "b1100011".U){//branch
    io.b_form:=1.B
    io.rs1:=(io.in(19,15))
    io.rs2:=(io.in(24,20))
    io.imm := Cat(Fill(19,io.in(31)),io.in(31,25),io.in(11,7))
    io.aluop := 0.U
    io.wr_back := 0.U
    io.mem_wr_en := 0.U
    io.wr_en :=0.B


}

}
