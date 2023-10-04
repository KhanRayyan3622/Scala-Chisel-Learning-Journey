package single_cycle

import chisel3 . _
import chisel3 . util . _

class Data_Mem extends Module {
  val io = IO(new Bundle {
    val wen = Input(Bool())
    val addr = Input(UInt(32.W))
    val din = Input(SInt(32.W))
    val dout = Output(SInt(32.W))
    val fun3 = Input(UInt(3.W))
    val enable = Input(Bool())
  })

  val mem = Mem(1024, Vec(4, SInt(8.W)))
  val mask = Wire(Vec(4, Bool()))
  val data = Wire(Vec(4, SInt(8.W)))
  val t_read = Wire(Vec(4, SInt(8.W)))

  io.dout := 0.S

  data(0) := io.din(7, 0).asSInt()
  data(1) := io.din(15, 8).asSInt()
  data(2) := io.din(23, 16).asSInt()
  data(3) := io.din(31, 24).asSInt()

  t_read(0) := 0.S
  t_read(1) := 0.S
  t_read(2) := 0.S
  t_read(3) := 0.S

  mask(0) := 0.B
  mask(1) := 0.B
  mask(2) := 0.B
  mask(3) := 0.B

  when(io.wen) {
    when(io.fun3 === 0.U) { //SB
      when(io.addr(1, 0) === 0.U) {
        mask(0) := 1.B
        mask(1) := 0.B
        mask(2) := 0.B
        mask(3) := 0.B
      }.elsewhen(io.addr(1, 0) === 1.U) {
        mask(0) := 0.B
        mask(1) := 1.B
        mask(2) := 0.B
        mask(3) := 0.B

        data(1) := io.din(7, 0).asSInt()


      }.elsewhen(io.addr(1, 0) === 2.U) {
        mask(0) := 0.B
        mask(1) := 0.B
        mask(2) := 1.B
        mask(3) := 0.B

        data(2) := io.din(7, 0).asSInt()


      }.elsewhen(io.addr(1, 0) === 3.U) {
        mask(0) := 0.B
        mask(1) := 0.B
        mask(2) := 0.B
        mask(3) := 1.B

        data(3) := io.din(7, 0).asSInt()
      }

    }
      .elsewhen(io.fun3 === 1.U) { // SH
        when(io.addr(1, 0) === 0.U) {
          mask(0) := 1.B
          mask(1) := 1.B
          mask(2) := 0.B
          mask(3) := 0.B

        }.elsewhen(io.addr(1, 0) === 1.U) {
          mask(0) := 0.B
          mask(1) := 1.B
          mask(2) := 1.B
          mask(3) := 0.B

          data(1) := io.din(7, 0).asSInt()
          data(2) := io.din(15, 8).asSInt()


        }.elsewhen(io.addr(1, 0) === 2.U) {
          mask(0) := 0.B
          mask(1) := 0.B
          mask(2) := 1.B
          mask(3) := 1.B

          data(2) := io.din(7, 0).asSInt()
          data(3) := io.din(15, 8).asSInt()


        }.elsewhen(io.addr(1, 0) === 3.U) {
          mask(0) := 0.B
          mask(1) := 0.B
          mask(2) := 0.B
          mask(3) := 1.B

          data(3) := io.din(7, 0).asSInt()
        }

      }
      .elsewhen(io.fun3 === 2.U) { // SW
        mask(0) := 1.B
        mask(1) := 1.B
        mask(2) := 1.B
        mask(3) := 1.B

      }
      mask(0) := 1.B
      mask(1) := 0.B
      mask(2) := 0.B
      mask(3) := 0.B
    mem.write(io.addr(31, 2),data,mask)

  }
  t_read := mem.read(io.addr(31,2))
  when(io.enable){
  t_read := mem.read(io.addr(31,2))
  when(io.fun3 === 0.U) {
    // Loading Byte now
    when(io.addr(1,0) === 0.U){
    io.dout := Cat(Fill(24,t_read(0)(7)),t_read(0)).asSInt()}
    .elsewhen(io.addr(1,0)=== 1.U){
    io.dout := Cat(Fill(24,t_read(1)(7)),t_read(1)).asSInt()}
    .elsewhen(io.addr(1,0)=== 2.U){
    io.dout := Cat(Fill(24,t_read(2)(7)),t_read(2)).asSInt()}
    .elsewhen(io.addr(1,0)=== 3.U){
    io.dout := Cat(Fill(24,t_read(3)(7)),t_read(3)).asSInt()}

    
  }.elsewhen(io.fun3 === 1.U) {
    //else Load Halfword
    when(io.addr(1,0) === 0.U){
    io.dout := Cat(Fill(16,t_read(0)(7)),t_read(0),t_read(1)).asSInt()}
    .elsewhen(io.addr(1,0)=== 1.U){
    io.dout := Cat(Fill(16,t_read(1)(7)),t_read(1),t_read(2)).asSInt()}
    .elsewhen(io.addr(1,0)=== 2.U){
    io.dout := Cat(Fill(16,t_read(2)(7)),t_read(2),t_read(3)).asSInt()}
    .elsewhen(io.addr(1,0)=== 3.U){
    io.dout := Cat(Fill(24,t_read(3)(7)),t_read(3)).asSInt()}

  }.elsewhen(io.fun3 === 2.U) { //lW
    io.dout := Cat(t_read(3), t_read(2), t_read(1), t_read(0)).asSInt()
  }
}
}
