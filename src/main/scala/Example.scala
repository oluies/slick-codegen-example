object Tables extends{ // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  val profile = scala.slick.driver.H2Driver  
} with demo.Tables
import Tables._
import Tables.profile.simple._

object SlickHandsOn {
  // connection info for a pre-populated throw-away, in-memory db for this demo, which is freshly initialized on every run
  val url = "jdbc:h2:mem:test;INIT=runscript from 'src/main/sql/create.sql'"
  val db = Database.forURL(url, driver = "org.h2.Driver")

  def computersByCompany(implicit session: Session) = {
    // Using generated code. Our Build.sbt makes sure they are generated before compilation.
    val q = Companies.join(Computers).on(_.id === _.manufacturerId)
      .map { case (co, cp) => (co.name, cp.name)}

    q.run.groupBy { case (co, cp) => co}
      .mapValues(_.map { case (co, cp) => cp})
      .mkString("\n")
  }

  def numAppleComputers(implicit session: Session) = {
    ???
  }

  def sortedAppleComputers(implicit session: Session) = {
    ???
  }

  def sortedAppleComputersRange(implicit session: Session) = {
    ???
  }

  def insertIPhone6s(implicit session: Session) = {
    ???
  }

  def deleteAppleComputers(implicit session: Session) = {
    ???
  }


  def updateIPhone(implicit session: Session) = {
    ???
  }

  def topLocation(implicit session: Session) = {
    ???
  }

  def main(args: Array[String]) = {
    println("Select running option:")
    db.withTransaction { implicit session =>
      val result = readInt() match {
        case 1 => computersByCompany
	      case 2 => numAppleComputers
        case 3 => sortedAppleComputers
        case 4 => sortedAppleComputersRange
        case 5 => insertIPhone6s
        case 6 => deleteAppleComputers
        case 7 => updateIPhone
        case 8 => topLocation
        case _ => "Invalid option"
      }
      println(result)
    }
  }
}