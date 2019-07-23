package pckg1;

import org.testng.annotations.Test;

public class Priority{
  @Test(priority=1)
  public void testpriority() {
	  System.out.println("this is google");
  }
  @Test(priority=2,enabled=false)
  public void testTwitter() {
	  System.out.println("this is twitter");
  }
  @Test(priority=3)
  public void testFacebook() {
	  System.out.println("this is facebook");
  }
}
