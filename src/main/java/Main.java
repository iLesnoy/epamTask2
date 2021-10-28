import epam.task.shapes.comparator.TetraHeightComparator;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.filereader.CustomFileReader;
import epam.task.shapes.observer.impl.TetraObserverImpl;
import epam.task.shapes.parser.CustomParser;
import epam.task.shapes.repository.impl.ConeRepositoryImpl;
import epam.task.shapes.repository.impl.IdSpecification;
import epam.task.shapes.service.CustomRepositoryService;
import epam.task.shapes.service.CustomWarehouseService;


import java.util.List;


public class Main {

    public static void main(String[] args) throws  CustomException {
        /*Logger logger = LogManager.getLogger();
        logger.info("privet");
        logger.error("fregefrerthrt");*/

        CustomRepositoryService repositoryService = new CustomRepositoryService();
        CustomWarehouseService warehouseService = new CustomWarehouseService();
        List<String> str = CustomFileReader.readValues("resources/file.txt");
        String string = String.join(" ",str);
        double [] arr = CustomParser.stringParse(string);
        Point point = new Point(-2,4,4);


        repositoryService.fillConeRepository(arr);
        repositoryService.fillConeRepository(1,2,3,4,2);
        repositoryService.fillConeRepository(1,2,3,8,2);
        repositoryService.fillConeRepository(point,3.4,5.6);
        warehouseService.fillConeWarehouse(point,3.4,5.6);


        Warehouse warehouse = Warehouse.getInstance();
        ConeRepositoryImpl repositoryimpl = ConeRepositoryImpl.getInstance();
        System.out.println(repositoryimpl.get(0));
        System.out.println(repositoryimpl.get(1));
        System.out.println(repositoryimpl.get(2));
        System.out.println(repositoryimpl.get(3));

        TetraObserverImpl observer = new TetraObserverImpl();
        repositoryimpl.get(0).attach(observer);
        repositoryimpl.get(0).setEdge(5);
        repositoryimpl.get(1).setEdge(3);
        repositoryimpl.get(1).attach(observer);
        repositoryimpl.get(1).setHeight(3);


        System.out.println(warehouse.getById(1L));
        System.out.println(warehouse.getById(2L));
        System.out.println(warehouse.getById(3L));
        System.out.println(warehouse.getById(4L));

        System.out.println(repositoryimpl.sort(new TetraHeightComparator()));
        System.out.println(repositoryimpl.query(new IdSpecification(1)));
    }
}
