package single_cycle

import chisel3._
import chisel3.util._

class Datapath extends Module {
  val io = IO(new Bundle {
      val out = Output (UInt(32.W))

  })
      val pc = Module (new Pc)
     val im = Module (new InstMem ("C:/Users/Saffy Yawar/Scala-Chisel-Learning-Journey/src/main/scala/gcd/inMem.txt"))
     val reg = Module (new  register)
      val cu = Module (new  controlunit)
      val alu = Module (new ALUD)
      val dmem = Module(new Datamem)
      val Bran = Module(new BranchControl)
  im.io.addr:=pc.io.addressout
        cu.io.in:=im.io.inst
        reg.io.ren:=cu.io.Wr_en
        reg.io.data:=alu.io.out
        reg.io.rs1:= cu.io.rs1
        reg.io.rs2:=cu.io.rs2
        reg.io.rd:=cu.io.rd
        alu.io.aluop:=cu.io.aluop
        alu.io.in_A:=reg.io.rs1out
        reg.io.ren:=cu.io.Wr_en
        dmem.io.Wr_en:=cu.io.mem_wr_en
        reg.io.data:=Mux(cu.io.Wr_back,alu.io.out,dmem.io.Dout)

        //alu.io.in_B:=reg.io.rs2out
        when( !cu.io.format || cu.io.sformat){
            alu.io.in_B := cu.io.imm
        }
        .otherwise{
         alu.io.in_B:=reg.io.rs2out   
        }
    io.out := alu.io.out


    

    






}

