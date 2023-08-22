package practice
import chisel3 . _
import chisel3.util._


class Seqcontroller extends  Module{
   val io = IO(new Bundle{
    //Input
    val opcode = Input (UInt (3.W))
        val zero = Input (Bool ())
            val rst_ = Input (Bool ())

            //output
val mem_rd = Output (Bool ())
val load_ir = Output (Bool ())
val halt = Output (Bool ())
val inc_pc = Output (Bool ())
val load_ac = Output (Bool ())
val load_pc = Output (Bool ())
val mem_wr = Output (Bool ())
   })
   io.mem_rd := 0.B
   io.load_ir := 0.B
   io.halt := 0.B
   io.inc_pc := 0.B
   io.load_ac := 0.B
   io.load_pc := 0.B
   io.mem_wr := 0.B

   val state = RegInit(0.U(3.W))
   when(state ===8.U){
   state := 0.U
   }
   .elsewhen(state === 0.U ){
    io.mem_rd := 0.B
    io.load_ir := 0.B
    io.halt := 0.B
    io.inc_pc := 0.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

    .elsewhen(state === 1.U ){
    io.mem_rd := 1.B
    io.load_ir := 0.B
    io.halt := 0.B
    io.inc_pc := 0.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

    .elsewhen(state === 2.U ){
    io.mem_rd := 1.B
    io.load_ir := 1.B
    io.halt := 0.B
    io.inc_pc := 0.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

    .elsewhen(state === 3.U ){
    io.mem_rd := 1.B
    io.load_ir := 1.B
    io.halt := 0.B
    io.inc_pc := 0.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

    .elsewhen(state === 4.U ){
    io.mem_rd := 0.B
    io.load_ir := 0.B
    when(io.opcode === 0.U){
       io.halt:=1.B
    }
    .otherwise {
       io. halt:=0.B
    }
    io.inc_pc := 1.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

   
    .elsewhen(state === 5.U ){
     when(io.opcode === 2.U || io.opcode === 3.U || io.opcode === 4.U ||io.opcode === 5.U  ){
       io.mem_rd:=1.B
    }
    .otherwise {
       io. mem_rd:=0.B
    }
    io.load_ir := 1.B
    io.halt := 0.B
    io.inc_pc := 0.B
    io.load_ac := 0.B
    io.load_pc:= 0.B
    io.mem_wr := 0.B
   }

    .elsewhen(state === 6.U ){
     when(io.opcode === 2.U || io.opcode === 3.U || io.opcode === 4.U ||io.opcode === 5.U  ){
       io.mem_rd:=1.B
    }
    .otherwise {
       io. mem_rd:=0.B
    }
    io.load_ir := 0.B
    io.halt := 0.B
    when(io.opcode === 1.U){
          io.inc_pc:=1.B
    }
    .otherwise {
       io. inc_pc:=0.B
    }

     when(io.opcode === 2.U || io.opcode === 3.U || io.opcode === 4.U ||io.opcode === 5.U  ){
       io.mem_rd:=1.B
    }
    .otherwise {
       io. mem_rd:=0.B
    }
    when(io.opcode === 7.U){
          io.load_pc:=1.B
    }
    .otherwise {
       io.load_pc:=0.B
    }

    io.mem_wr := 0.B
   }

   .elsewhen(state === 7.U ){
    when(io.opcode === 2.U || io.opcode === 3.U || io.opcode === 4.U ||io.opcode === 5.U  ){
       io.mem_rd:=1.B
    }
    .otherwise {
       io. mem_rd:=0.B
    }
    io.load_ir := 0.B
    io.halt := 0.B
    when(io.opcode === 7.U){
          io.inc_pc:=1.B
    }
    .otherwise {
       io.inc_pc:=0.B
    }
    when(io.opcode === 2.U || io.opcode === 3.U || io.opcode === 4.U ||io.opcode === 5.U  ){
       io.load_ac:=1.B
    }
    .otherwise {
       io. load_ac:=0.B
    }

    when(io.opcode === 7.U){
          io.load_pc:=1.B
    }
    .otherwise {
       io.load_pc:=0.B
    }
    io.mem_wr := 0.B
    when(io.opcode === 6.U){
          io.mem_wr:=1.B
    }
    .otherwise {
       io.mem_wr:=0.B
    }
   }
   state:=state+1.U
}


