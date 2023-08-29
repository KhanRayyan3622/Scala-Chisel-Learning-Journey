package lab5
import chisel3 . _
import chisel3 . util . _
import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
// your code for Transaction_in class
// your code for Transaction_out class
class Router [ T <: Data ]( gen : T ) extends Module {
// your code begin
class packet [ T <: Data ]( gen : T ) extends Bundle
{
    val data = Input(gen)
     val address = Input(UInt(4.W))
}
// your code end
}
