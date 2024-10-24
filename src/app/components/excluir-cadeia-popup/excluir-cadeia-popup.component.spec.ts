import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcluirCadeiaPopupComponent } from './excluir-popup.component';

describe('ExcluirPopupComponent', () => {
  let component: ExcluirCadeiaPopupComponent;
  let fixture: ComponentFixture<ExcluirCadeiaPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExcluirCadeiaPopupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExcluirCadeiaPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
