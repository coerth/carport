package dat.startcode.model.persistence;

import dat.startcode.model.DTO.CarportRequestDTO;

public interface ICarportRequestDTOMapper {

    CarportRequestDTO getSpecificCarportRequestDTO (int carportRequestId);

}
