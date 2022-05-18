package dat.startcode.model.persistence;

import dat.startcode.model.DTO.AccountDTO;

public interface IAccountDTOMapper {

    AccountDTO getAccountAndCustomerDTO (int customerId);

}
