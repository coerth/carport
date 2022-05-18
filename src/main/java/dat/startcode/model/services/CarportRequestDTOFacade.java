package dat.startcode.model.services;

import dat.startcode.model.DTO.CarportRequestDTO;
import dat.startcode.model.persistence.CarportRequestDTOMapper;
import dat.startcode.model.persistence.ConnectionPool;

public class CarportRequestDTOFacade {

    public static CarportRequestDTO getSpecificCarportRequestDTO(int carportRequestId) {
        CarportRequestDTO carportRequestDTO = new CarportRequestDTO(carportRequestId);

    }

}
