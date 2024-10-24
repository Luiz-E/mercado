import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarDatasComponent } from './listar-datas.component';

describe('ListarDatasComponent', () => {
  let component: ListarDatasComponent;
  let fixture: ComponentFixture<ListarDatasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarDatasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarDatasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
