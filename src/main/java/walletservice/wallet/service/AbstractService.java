package walletservice.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService <E,R extends JpaRepository<E,String>>{
    @Autowired
    protected R repository;

    public E insert(E entity){
        return repository.save(entity);
    }
    public void update(E entity){
        this.repository.save(entity);
    }
    public void deleteById(String id){
        this.repository.deleteById(id);
    }
    public E findById(String id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }
    public List<E> findAll(){
        return repository.findAll();
    }
    public List<E> findByExample(E entity){
        return repository.findAll(Example.of(entity));
    }
}
