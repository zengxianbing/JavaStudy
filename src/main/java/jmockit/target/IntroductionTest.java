package jmockit.target;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cengxianbing on 2015/11/10.
 */
public class IntroductionTest
{
    @Mocked
    private WinportUrlService winportUrlService = null;

    @Test
    public void testNoExpectations()
    {
        final String memberId = "test2009";
        Assert.assertEquals(false, winportUrlService.hasWinport(memberId));
    }

    @Test
    public void testWithExpectatons()
    {
        final String memberId = "test2009";

        new Expectations()
        {
            {
                winportUrlService.hasWinport(memberId);
                result = false;
                times = 1;
            }
        };

        Assert.assertEquals(false, winportUrlService.hasWinport(memberId));
    }

    ;

}
