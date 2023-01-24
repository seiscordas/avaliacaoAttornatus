package com.kl.avaliacaoAttornatus.services;

import com.kl.avaliacaoAttornatus.dto.AddressDTO;
import com.kl.avaliacaoAttornatus.entities.Address;
import com.kl.avaliacaoAttornatus.entities.Person;
import com.kl.avaliacaoAttornatus.repositories.AddressRepository;
import com.kl.avaliacaoAttornatus.repositories.PersonRepository;
import com.kl.avaliacaoAttornatus.services.exceptions.ResourceNotFoundException;
import com.kl.avaliacaoAttornatus.tests.Factory;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class AddressServiceTests {
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private AddressService service;
    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private AddressDTO addressDTO;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        dependentId = 3L;
        Person person = Factory.createPerson();
        Address address = Factory.createAddress();
        addressDTO = Factory.createAddressDTO();
        List<Address> addressList = new ArrayList<>();

        Mockito.when(addressRepository.save(any())).thenReturn(address);

        Mockito.when(addressRepository.findById(existingId)).thenReturn(Optional.of(address));

        Mockito.when(addressRepository.findAllByPerson(person)).thenReturn(addressList);
        Mockito.when(addressRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);

        Mockito.when(personRepository.getReferenceById(existingId)).thenReturn(person);
        Mockito.when(personRepository.getReferenceById(existingId)).thenReturn(person);
        Mockito.when(personRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(addressRepository).deleteById(existingId);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(addressRepository).deleteById(nonExistingId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(addressRepository).deleteById(dependentId);
    }

    @Test
    public void insertShouldReturnAddressDTOWhenCreateAddress() {
        AddressDTO result = service.insert(addressDTO);
        Assertions.assertNotNull(result);
    }

    @Test
    public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.update(nonExistingId, addressDTO));
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(nonExistingId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });
        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(existingId);
    }
}
