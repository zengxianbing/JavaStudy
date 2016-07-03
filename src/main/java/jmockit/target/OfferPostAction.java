package jmockit.target;

/**
 * Created by cengxianbing on 2015/11/10.
 */
public class OfferPostAction
{
    private WinportUrlServiceImpl winportUrlService=new WinportUrlServiceImpl();

    public boolean hasWinport(String memeberId){
        return winportUrlService.hasWinport(memeberId);
    }

    public String getWinportUrlThrowException(String memberId){
        return winportUrlService.getWinportUrlThrowException(memberId);
    }

    public long getPostedOfferCounts(String memberId){
        return winportUrlService.getPostedOfferCounts(memberId);
    }
}
