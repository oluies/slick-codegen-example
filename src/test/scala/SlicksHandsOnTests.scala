import Tables._
import Tables.profile.simple._
import org.scalatest.FunSuite

/**
 * Created by magnus on 21/10/14.
 */
class SlicksHandsOnTests extends FunSuite {

  val url = "jdbc:h2:mem:test;INIT=runscript from 'src/main/sql/create.sql'"
  val db = Database.forURL(url, driver = "org.h2.Driver")

  test("computersByCompany") {
    db.withTransaction { implicit session =>
      SlickHandsOn.computersByCompany

    }
  }

  test("numAppleComputers") {
    db.withTransaction { implicit session =>
      val result = SlickHandsOn.numAppleComputers
    }
  }

  test("sortedAppleComputers") {
    db.withTransaction { implicit session =>
      SlickHandsOn.sortedAppleComputers
    }
  }

  test("sortedAppleComputersRange") {
    db.withTransaction { implicit session =>
      SlickHandsOn.sortedAppleComputersRange
    }
  }

  test("insertIPhone6s") {
    db.withTransaction { implicit session =>
      SlickHandsOn.insertIPhone6s
    }
  }

  test("deleteAppleComputers") {
    db.withTransaction { implicit session =>
      SlickHandsOn.deleteAppleComputers
    }
  }

  test("updateIPhone") {
    db.withTransaction { implicit session =>
      SlickHandsOn.updateIPhone
    }
  }

  test("topLocation") {
    db.withTransaction { implicit session =>
      SlickHandsOn.topLocation
    }
  }


}

