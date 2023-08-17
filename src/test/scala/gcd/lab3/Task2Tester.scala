package lab3
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import chisel3.fromIntToLiteral
import chisel3._



class Task2Tester extends FreeSpec with ChiselScalatestTester {
  " Task 2 Tester file" in {
    test(new generator){ b =>
      b.io.instr.poke("b11111101001100000000000010010011".U)
      b.io.immd_c.expect(-45.S)
      b.clock.step(10)

    }
  }
}