import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarPaginaComponent } from './adicionar-pagina.component';

describe('AtualizarPaginaComponent', () => {
  let component: AdicionarPaginaComponent;
  let fixture: ComponentFixture<AdicionarPaginaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdicionarPaginaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdicionarPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
