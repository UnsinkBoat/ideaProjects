import java.util.Arrays;
import java.util.Objects;

public class Mapping  {

    public boolean ismapping(Definition x[],Range y){
        for(int i=0;i<x.length;i++) {
            Object temp = x[i].yunsuanfaze();
            if(!y.contains(temp)){
                return false;
            }
        }
        return true;
    }

    public boolean singleshot(Definition[]x,Range y ){
        if(ismapping(x,y)){
            for(int i=0;i<x.length;i++)
                for(int j=i+1;j<x.length;j++){
                    if(x[i].yunsuanfaze()==x[j].yunsuanfaze())
                        return false;
                }
            return true;
        }else{
//            System.out.println("不是映射");
            return false;
        }
    }

    public boolean fullshot(Definition[]x,Range y){
        if(ismapping(x,y)){
            Object obj[] = new Object[x.length];
            for(int i =0;i<x.length;i++){
                obj[i] = x[i].yunsuanfaze();
            }
            return y.equals(new Range(obj));
        }else{
//            System.out.println("不是映射");
            return false;
        }
    }

    public boolean doubleshot(Definition[]x,Range y){
        return singleshot(x,y)&&fullshot(x,y);
    }

}
class Definition implements Algorithm{

    Object obj;

    public Definition(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object yunsuanfaze() {
        Integer y = (int)obj;
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(obj, that.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "obj=" + obj +
                '}';
    }
}

class Range {
    Object[]obj;

    public Range(Object[] obj) {
        this.obj = obj;
    }

    public boolean contains(Object o){
        for(int i=0;i<obj.length;i++){
            if(obj[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return Arrays.equals(obj, range.obj);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(obj);
    }
}

