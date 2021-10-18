import epam.task.shapes.comparator.TetraHeightComparator;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.filereader.CustomFileReader;
import epam.task.shapes.observer.Impl.TetraObserverImpl;
import epam.task.shapes.parser.CustomParser;
import epam.task.shapes.repository.impl.ConeRepositoryimpl;
import epam.task.shapes.repository.impl.HeightSpecification;
import epam.task.shapes.service.CustomRepositoryService;
import epam.task.shapes.service.CustomWarehouseService;


import java.util.List;


public class Main {

    public static void main(String[] args) throws  CustomException {

        CustomRepositoryService repositoryService = new CustomRepositoryService();
        CustomWarehouseService warehouseService = new CustomWarehouseService();
        List<String> str = CustomFileReader.readAllFile("resources/file.txt");
        String string = String.join(" ",str);
        double [] arr = CustomParser.stringParse(string);
        repositoryService.fillConeRepository(arr);
        warehouseService.fillConeWarehouse(arr);


        repositoryService.fillConeRepository(1,2,3,4,10);
        warehouseService.fillConeWarehouse(1,2,3,4,10);
        Point point = new Point(1,2,3);
        repositoryService.fillConeRepository(point,3.4,5.6);
        warehouseService.fillConeWarehouse(point,3.4,5.6);
        Warehouse warehouse = Warehouse.getInstance();
        ConeRepositoryimpl repositoryimpl = ConeRepositoryimpl.getInstance();
        System.out.println(repositoryimpl.get(1));
        System.out.println(repositoryimpl.get(2));
        TetraObserverImpl observer = new TetraObserverImpl();
        repositoryimpl.get(1).attach(observer);
        repositoryimpl.get(1).setHeight(0.5);
        /*System.out.println(warehouse.get(1L));
        System.out.println(warehouse.get(2L));
        System.out.println(warehouse.get(3L));*/
        System.out.println(repositoryimpl.sort(new TetraHeightComparator()));
        System.out.println(repositoryimpl.query(new HeightSpecification(1, 5)));

    }
}
